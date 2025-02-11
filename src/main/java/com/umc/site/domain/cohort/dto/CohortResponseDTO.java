package com.umc.site.domain.cohort.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CohortResponseDTO {

    // 기수 목록 조회
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CohortInfoDTO {
        private Long cohortId;
        private String name;
    }
}
