package com.gamebasic.ranking.service;

import com.gamebasic.game.repository.GameRepository;
import com.gamebasic.ranking.RankingClient;
import com.gamebasic.ranking.dto.GameRecord;
import com.gamebasic.ranking.dto.RankingResponse;
import com.gamebasic.ranking.dto.RankingSource;
import com.gamebasic.runcard.entity.CardType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RankingService {

    private final RankingClient rankingClient;

    public RankingResponse getRankings() {
        RankingSource source = rankingClient.fetch();
        List<GameRecord> records = new ArrayList<>();


        List<RankingSource.RankItem> candiates = source.records().stream()
                .filter(item -> item.run().status().equals("CLEARED"))
                .filter(item -> item.run().clearedFloor() == 10)
                .filter(item -> item.bossFight() != null).toList();


        List<RankingSource.RankItem> validRankItems = candiates.stream()
                .filter(item -> item.run().durationSeconds() >= 30 * item.run().clearedFloor())
                .filter(item -> item.run().finalHp() >= 1 && item.run().finalHp() <= 99)
                .filter(item -> item.deck().size() >= 9 && item.deck().size() <= 20)
                .filter(item -> item.deck().cards().stream().allMatch(card -> CardType.isValid(card.cardType())))
                .filter(item -> item.deck().cards().stream().allMatch(card -> card.acquiredFloor() >= 0 && card.acquiredFloor() <= 9))
                .filter(item -> item.bossFight().phases().stream().allMatch(phase -> phase.turns() > 0))
                .filter(item -> item.bossFight().isValidPhase())
                .filter(item -> item.deck().cards().stream().anyMatch(card -> card.cardType().equals(item.bossFight().finishingCard())))
                .toList();

        int excludedCount = candiates.size() - validRankItems.size();

        List<RankingSource.RankItem> sortedRankItems = validRankItems.stream()
                .sorted(Comparator.comparingInt((RankingSource.RankItem item) -> item.run().durationSeconds())
                        .thenComparing(Comparator.comparingInt((RankingSource.RankItem item) -> item.run().finalHp()).reversed())
                        .thenComparingLong(item -> item.id()))
                .toList();

        List<String> playerIds = new ArrayList<>();

        for (int i = 0; i < sortedRankItems.size(); i++) {

            if (playerIds.contains(sortedRankItems.get(i).player().id()))
                continue;

            playerIds.add(sortedRankItems.get(i).player().id());
            records.add(
                    new GameRecord(records.size() + 1,
                            sortedRankItems.get(i).player().name(),
                            sortedRankItems.get(i).run().durationSeconds(),
                            sortedRankItems.get(i).run().finalHp(),
                            sortedRankItems.get(i).bossFight().totalTurns(),
                            sortedRankItems.get(i).deck().size()));
        }

        return new RankingResponse(source.meta().season().id(), source.meta().totalRecords(), excludedCount, records);
    }
}
