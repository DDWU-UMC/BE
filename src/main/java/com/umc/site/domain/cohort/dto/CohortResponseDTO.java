package com.umc.site.domain.cohort.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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

    // 기수 추가
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateCohortResultDTO {
        private Long cohortId;
        private String name;
        private LocalDateTime createdAt;
    }

    // 기수 수정
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateCohortResultDTO {
        private Long cohortId;
        private String name;
        private LocalDateTime updatedAt;
    }
}
