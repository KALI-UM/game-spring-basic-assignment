package com.gamebasic.ranking.dto;

import java.util.List;


public record RankingSource (Meta meta, List<RankItem> records){

    public record Meta(
            Season season,
            //불필요 LocalDateTime generatedAt,
            //불필요 String schemaVersion,
            int totalRecords
    ) {
    }

    public record Season(
            String id,
            String name
            //불필요 LocalDateTime startsAt,
            //불필요 LocalDateTime endsAt
    ) {
    }


    public record RankItem(
            Long id,
            Player player,
            Run run,
            BossFight bossFight,
            Deck deck
    ) {
    }

    public record Player(
            String id,
            String name
    ) {
    }

    public record Run(
            String status,
            int clearedFloor,
            int durationSeconds,
            int finalHp
    ){}

    public record BossFight(
            List<Phase> phases,
            String finishingCard,
            int totalTurns
    ){
        public boolean isValidPhase()
        {
            if(phases()==null||phases.size()!=3)
                return false;

            List<String> phaseNames = List.of(
                    "THRONE",
                    "UNBOUND",
                    "ECLIPSE"
            );

            int phaseTurns=0;
            for(int i=0; i<3; i++)
            {
                if(!phases.get(i).phase().equals(phaseNames.get(i)))
                    return false;

                phaseTurns+=phases.get(i).turns;
            }

            if(phaseTurns!=totalTurns)
                return false;

            return true;
        }
    }

    public record Phase(
            String phase,
            int turns,
            int damageTaken)
    {}

    public record Deck(
            int size,
            List<Card> cards
    )
    {}

    public record Card(
            String cardType,
            int acquiredFloor
    )
    {}

}
