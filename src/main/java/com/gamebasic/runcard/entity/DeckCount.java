package com.gamebasic.runcard.entity;

import lombok.Getter;

@Getter
public class DeckCount {

    private Long gameId;
    private Long deckCount;

    public DeckCount(Long gameId, Long deckCount) {
        this.gameId = gameId;
        this.deckCount = deckCount;
    }
}
