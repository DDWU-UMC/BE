package com.umc.site.domain.part.dto;

import com.umc.site.domain.part.entity.enums.PartType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class PartResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RecruitingPartDTO {
        private Long partId;
        private PartType partType;
        private String name;
    }
}
