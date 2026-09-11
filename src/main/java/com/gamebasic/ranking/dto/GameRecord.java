package com.gamebasic.ranking.dto;

import lombok.Getter;

@Getter
public class GameRecord {
    int rank;
    String playerName;
    int clearTimeSeconds;
    int remainingHp;
    int bossTurns;
    int deckSize;

    public GameRecord(int rank, String playerName, int clearTimeSeconds, int remainingHp, int bossTurns, int deckSize) {
        this.rank = rank;
        this.playerName = playerName;
        this.clearTimeSeconds = clearTimeSeconds;
        this.remainingHp = remainingHp;
        this.bossTurns = bossTurns;
        this.deckSize = deckSize;
    }
}
