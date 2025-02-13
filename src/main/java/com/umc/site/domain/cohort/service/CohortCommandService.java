package com.umc.site.domain.cohort.service;

import com.umc.site.domain.cohort.dto.CohortRequestDTO;
import com.umc.site.domain.cohort.dto.CohortResponseDTO;

public interface CohortCommandService {

    // 기수 추가
    CohortResponseDTO.CreateCohortResultDTO createCohort(CohortRequestDTO.CreateCohortDTO request);
}
