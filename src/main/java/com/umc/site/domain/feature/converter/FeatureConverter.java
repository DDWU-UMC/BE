package com.umc.site.domain.feature.converter;

import com.umc.site.domain.feature.dto.FeatureRequestDTO;
import com.umc.site.domain.feature.dto.FeatureResponseDTO;
import com.umc.site.domain.feature.entity.Feature;
import com.umc.site.domain.project.entity.Project;

public class FeatureConverter {

    public static FeatureResponseDTO.FeatureDTO toFeatureDTO(Feature feature) {

        return FeatureResponseDTO.FeatureDTO.builder()
                .content(feature.getContent())
                .build();
    }

    // 핵심 기능 생성
    public static Feature toFeature(FeatureRequestDTO.CreatFeatureDTO request, Project project) {
        return Feature.builder()
                .content(request.getContent())
                .project(project)
                .build();
    }
}
