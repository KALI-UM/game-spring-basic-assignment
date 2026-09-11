package com.gamebasic.ranking.dto;

import lombok.Getter;
import java.util.List;

@Getter
public class RankingResponse {
    String season;
    int totalRecords;
    int excludedCount;
    List<GameRecord> entries;

    public RankingResponse(String season, int totalRecord, int excludedCount, List<GameRecord> entries) {
        this.season = season;
        this.totalRecords = totalRecord;
        this.excludedCount = excludedCount;
        this.entries = entries;
    }
}
