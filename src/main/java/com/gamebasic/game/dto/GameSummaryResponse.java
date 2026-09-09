package com.gamebasic.game.dto;

import com.gamebasic.game.entity.GamePhase;
import com.gamebasic.game.entity.GameStatus;
import lombok.Getter;

@Getter
public class GameSummaryResponse {
    private Long id;
    private String playerName;
    private int currentFloor;
    private int currentHp;
    private GamePhase phase;
    private GameStatus status;
    private int deckSize;

    public GameSummaryResponse(Long id, String playerName, int currentHp, int currentFloor, GamePhase phase, GameStatus status, int deckSize) {
        this.id = id;
        this.playerName = playerName;
        this.currentHp = currentHp;
        this.currentFloor = currentFloor;
        this.phase = phase;
        this.status = status;
        this.deckSize = 0;
    }
}
