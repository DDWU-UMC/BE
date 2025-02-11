package com.umc.site.domain.project.converter;

import com.umc.site.domain.image.converter.ImageConverter;
import com.umc.site.domain.image.entity.Image;
import com.umc.site.domain.project.dto.ProjectResponseDTO;
import com.umc.site.domain.project.entity.Project;

public class ProjectConverter {

    // 기수별 프로젝트 목록 조회
    public static ProjectResponseDTO.ProjectPreviewDTO toProjectPreviewDTO(Project project, Image image) {

        return ProjectResponseDTO.ProjectPreviewDTO.builder()
                .projectId(project.getId())
                .title(project.getTitle())
                .pm(project.getPm())
                .front_end(project.getFront_end())
                .back_end(project.getBack_end())
                .serviceType(project.getServiceType())
                .image(ImageConverter.toImageDTO(image))
                .build();
    }
}
