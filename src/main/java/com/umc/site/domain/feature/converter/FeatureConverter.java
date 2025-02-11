package com.umc.site.domain.feature.converter;

import com.umc.site.domain.feature.dto.FeatureResponseDTO;
import com.umc.site.domain.feature.entity.Feature;

public class FeatureConverter {

    public static FeatureResponseDTO.FeatureDTO toFeatureDTO(Feature feature) {

        return FeatureResponseDTO.FeatureDTO.builder()
                .content(feature.getContent())
                .build();
    }
}
