package com.gamebasic.runcard.entity;

public enum CardType {
    STRIKE("베기"),
    GUARD("밤의 장막"),
    MIST_KNOT("안개 매듭"),
    HEAVY_BLOW("내리베기"),
    TENDON_SEVER("힘줄 끊기"),
    TWIN_SLASH("쌍베기"),
    QUICK_SLASH("빠른 베기"),
    IRON_WALL("안개 장막"),
    BLOOD_RUNE("흡수"),
    ECHO_GUARD("피의 방패"),
    SUNDER("난도질"),
    MEND("피의 갈증"),
    COUNTER_SIGIL("혈흔 각인"),
    ARCANE_BOLT("혈창"),
    WARDING_SLASH("안개 베기"),
    RUNE_SURGE("피의 계약"),
    SHATTER_BOLT("혈흔 절개"),
    EXECUTION_RUNE("혈폭풍"),
    BLOOD_AMPLIFY("피의 증폭"),
    LAST_STAND("불사의 밤"),
    DECAPITATE("참수"),
    NIGHT_DANCE("밤의 검무"),
    MIST_FORM("안개 형상"),
    NIGHT_FEAST("밤의 만찬"),
    SCARLET_MEMORY("붉은 기억"),
    BLOOD_OFFERING("피의 공물"),
    SEALED_WOUND("닫히지 않는 상처"),
    THIRSTING_BLOW("갈증의 일격"),
    BLOOD_TOLL("피의 대가"),
    NIGHT_TITHE("밤의 징수"),
    CRIMSON_RECLAIM("붉은 회수"),
    HEART_PIERCE("심장찌르기"),
    SHATTER_ARMOR("갑주 파쇄"),
    VOID_NIGHT("무형의 밤"),
    NIGHT_AFTERIMAGE("밤의 잔영"),
    KILLING_MOMENTUM("살의의 고조"),
    LINGERING_THUNDER("잔뢰"),
    SECOND_HEART("두 번째 심장");

    private final String description;

    CardType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
