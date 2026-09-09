package com.gamebasic.runcard.dto;

import com.gamebasic.runcard.entity.CardType;
import lombok.Getter;

@Getter
public class CardResponse {
    // TODO (Lv 5): API 명세의 카드 응답 JSON에 맞게 필드를 만들고 생성자에서 채우세요.
    private Long id;
    private CardType cardType;
    private int acquiredFloor;

    public CardResponse(Long id, CardType cardType, int acquiredFloor) {
        this.id = id;
        this.cardType = cardType;
        this.acquiredFloor = acquiredFloor;
    }
}
