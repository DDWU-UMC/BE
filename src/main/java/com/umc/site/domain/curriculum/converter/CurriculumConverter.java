package com.umc.site.domain.curriculum.converter;

import com.umc.site.domain.curriculum.dto.CurriculumResponseDTO;
import com.umc.site.domain.curriculum.entity.Curriculum;

public class CurriculumConverter {

    public static CurriculumResponseDTO.CurriculumInfoDTO toCurriculumInfoDTO(Curriculum curriculum) {

        return CurriculumResponseDTO.CurriculumInfoDTO.builder()
                .curriculumId(curriculum.getId())
                .week(curriculum.getWeek())
                .content(curriculum.getContent())
                .build();
    }
}
