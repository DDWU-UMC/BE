package com.umc.site.domain.project.converter;

import com.umc.site.domain.feature.converter.FeatureConverter;
import com.umc.site.domain.feature.entity.Feature;
import com.umc.site.domain.image.converter.ImageConverter;
import com.umc.site.domain.image.entity.Image;
import com.umc.site.domain.project.dto.ProjectResponseDTO;
import com.umc.site.domain.project.entity.Project;

import java.util.List;

public class ProjectConverter {

    // 기수별 프로젝트 목록 조회
    public static ProjectResponseDTO.ProjectPreviewDTO toProjectPreviewDTO(Project project, Image image) {

        return ProjectResponseDTO.ProjectPreviewDTO.builder()
                .projectId(project.getId())
                .title(project.getTitle())
                .pm(project.getPm())
                .frontEnd(project.getFrontEnd())
                .backEnd(project.getBackEnd())
                .design(project.getDesign())
                .serviceType(project.getServiceType())
                .image(ImageConverter.toImageDTO(image))
                .build();
    }

    // 프로젝트 상세 정보 조회
    public static ProjectResponseDTO.ProjectDetailDTO toProjectDetailDTO(Project project, Image image, List<Feature> features) {

        return ProjectResponseDTO.ProjectDetailDTO.builder()
                .projectId(project.getId())
                .title(project.getTitle())
                .serviceType(project.getServiceType())
                .pm(project.getPm())
                .frontEnd(project.getFrontEnd())
                .backEnd(project.getBackEnd())
                .design(project.getDesign())
                .description(project.getDescription())
                .cohort(project.getCohort().getName())
                .features(features.stream()
                        .map(FeatureConverter::toFeatureDTO)
                        .toList())
                .image(ImageConverter.toImageDTO(image))
                .build();
    }

    // n기 다른 프로젝트 보기 목록 조회
    public static ProjectResponseDTO.OtherProjectDTO toOtherProjectDTO(Project project, Image image) {
        return ProjectResponseDTO.OtherProjectDTO.builder()
                .projectId(project.getId())
                .title(project.getTitle())
                .serviceType(project.getServiceType())
                .image(ImageConverter.toImageDTO(image))
                .build();
    }
}
