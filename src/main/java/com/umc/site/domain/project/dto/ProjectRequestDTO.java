package com.umc.site.domain.project.dto;

import com.umc.site.domain.feature.dto.FeatureRequestDTO;
import com.umc.site.domain.project.enums.ServiceType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.List;

public class ProjectRequestDTO {
    
    // 프로젝트 생성
    @Getter
    public static class CreateProjectDTO {

        // 프로젝트명
        @NotBlank
        private String title;

        // 기획 사람들
        @NotBlank
        private String pm;

        // 프론트엔드 사람들
        @NotBlank
        private String frontEnd;

        // 백엔드 사람들
        @NotBlank
        private String backEnd;

        // 디자인 사람들
        @NotBlank
        private String design;

        // 서비스 유형
        @NotNull(message = "WEB/IOS/ANDROID")
        private ServiceType serviceType;

        // 프로젝트 설명
        private String description;

        // 프로젝트 한줄 소개
        @NotBlank
        private String introduction;

        // 기수
        @NotNull
        private Long cohortId;

        // 프로젝트 핵심 기능
        @Size(min = 1)
        private List<FeatureRequestDTO.CreatFeatureDTO> featureList;
    }

    // 프로젝트 수정
    @Getter
    public static class UpdateProjectDTO {

        @NotBlank
        private String title;   // 프로젝트명

        @NotBlank
        private String pm;  // 기획 사람들

        @NotBlank
        private String frontEnd;    // 프론트엔드 사람들

        @NotBlank
        private String backEnd; // 백엔드 사람들

        @NotBlank
        private String design;  // 디자인 사람들

        @NotNull(message = "WEB/IOS/ANDROID")
        private ServiceType serviceType;    // 서비스 유형

        private String description;  // 프로젝트 설명

        @NotBlank
        private String introduction;    // 프로젝트 한줄 소개

        @NotNull
        private Long cohortId;  // 기수

        @Size(min = 1)
        private List<FeatureRequestDTO.CreatFeatureDTO> featureList;    // 프로젝트 핵심 기능
    }
}
