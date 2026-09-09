package com.gamebasic.runcard.dto;

import com.gamebasic.runcard.entity.CardType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class RunCardRequest {
    // TODO (Lv 5): API 명세의 카드 필드 제약을 Bean Validation 어노테이션으로 붙이세요.
    @NotNull
    private CardType cardType;
    @Min(0) @Max(10)
    private Integer acquiredFloor;
}
