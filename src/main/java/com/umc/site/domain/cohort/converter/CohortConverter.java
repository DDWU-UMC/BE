package com.umc.site.domain.cohort.converter;


import com.umc.site.domain.cohort.dto.CohortRequestDTO;
import com.umc.site.domain.cohort.dto.CohortResponseDTO;
import com.umc.site.domain.cohort.entity.Cohort;

public class CohortConverter {

    // 기수 목록 조회
    public static CohortResponseDTO.CohortInfoDTO toCohortInfoDTO(Cohort cohort) {

        return CohortResponseDTO.CohortInfoDTO.builder()
                .cohortId(cohort.getId())
                .name(cohort.getName())
                .build();
    }

    public static Cohort toCohort(CohortRequestDTO.CreateCohortDTO request){

        return Cohort.builder()
                .name(request.getName())
                .build();
    }

    // 기수 생성
    public static CohortResponseDTO.CreateCohortResultDTO toCreateCohortResultDTO(Cohort cohort){

        return CohortResponseDTO.CreateCohortResultDTO.builder()
                .cohortId(cohort.getId())
                .name(cohort.getName())
                .createdAt(cohort.getCreatedAt())
                .build();
    }
}
