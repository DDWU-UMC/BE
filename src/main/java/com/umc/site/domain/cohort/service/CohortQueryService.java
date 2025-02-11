package com.umc.site.domain.cohort.service;

import com.umc.site.domain.cohort.dto.CohortResponseDTO;

import java.util.List;

public interface CohortQueryService {

    // 기수 목록 조회
    List<CohortResponseDTO.CohortInfoDTO> getCohortList();
}
