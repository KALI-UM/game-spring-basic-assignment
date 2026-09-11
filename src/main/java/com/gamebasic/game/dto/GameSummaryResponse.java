package com.gamebasic.game.dto;

import com.gamebasic.game.entity.GamePhase;
import com.gamebasic.game.entity.GameStatus;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GameSummaryResponse {
    private Long id;
    private String playerName;
    private int currentFloor;
    private int currentHp;
    private GamePhase phase;
    private GameStatus status;
    private Long deckSize;

    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public GameSummaryResponse(Long id, String playerName, int currentHp, int currentFloor, GamePhase phase, GameStatus status, Long deckSize,LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.playerName = playerName;
        this.currentHp = currentHp;
        this.currentFloor = currentFloor;
        this.phase = phase;
        this.status = status;
        this.deckSize = deckSize;

        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
