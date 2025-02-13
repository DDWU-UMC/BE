package com.umc.site.domain.feature.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class FeatureRequestDTO {

    // 핵심 기능 생성
    @Getter
    public static class CreatFeatureDTO {
        @NotBlank
        private String content;
    }
}