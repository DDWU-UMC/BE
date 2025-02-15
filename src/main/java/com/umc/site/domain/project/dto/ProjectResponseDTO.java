package com.umc.site.domain.project.dto;

import com.umc.site.domain.feature.dto.FeatureResponseDTO;
import com.umc.site.domain.image.dto.ImageResponseDTO;
import com.umc.site.domain.project.enums.ServiceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class ProjectResponseDTO {

    // 프로젝트 목록 조회
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProjectPreviewDTO {
        private Long projectId;
        private String title;
        private String pm;
        private String frontEnd;
        private String backEnd;
        private String design;
        private ServiceType serviceType;
        private ImageResponseDTO.ImageDTO image;
    }

    // 프로젝트 상세 정보 조회
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProjectDetailDTO {
        private Long projectId;
        private String cohort;
        private String title;
        private ServiceType serviceType;
        private String pm;
        private String frontEnd;
        private String backEnd;
        private String design;
        private String description;
        private String introduction;
        private List<FeatureResponseDTO.FeatureDTO> features;
        private ImageResponseDTO.ImageDTO image;
    }

    // n기 다른 프로젝트 보기 목록 조회
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OtherProjectDTO {
        private Long projectId;
        private String title;
        private ServiceType serviceType;
        private ImageResponseDTO.ImageDTO image;
    }

    // 프로젝트 생성
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateProjectResultDTO {
        private Long projectId;
        private LocalDateTime createdAt;
    }

    // 프로젝트 수정
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateProjectResultDTO {
        private Long projectId;
        private LocalDateTime updatedAt;
    }
}
