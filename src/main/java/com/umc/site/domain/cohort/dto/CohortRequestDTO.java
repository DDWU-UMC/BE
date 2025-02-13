package com.umc.site.domain.cohort.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class CohortRequestDTO {

    // 기수 추가
    @Getter
    public static class CreateCohortDTO {
        @NotBlank
        private String name;
    }
}
