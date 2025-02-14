package com.umc.site.domain.curriculum.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CurriculumResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CurriculumInfoDTO {
        private Long curriculumId;
        private Integer week;
        private String content;
    }
}
