package com.umc.site.domain.cohort.service;

import com.umc.site.domain.cohort.converter.CohortConverter;
import com.umc.site.domain.cohort.dto.CohortResponseDTO;
import com.umc.site.domain.cohort.entity.Cohort;
import com.umc.site.domain.cohort.repository.CohortRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CohortQueryServiceImpl implements CohortQueryService{
    private final CohortRepository cohortRepository;

    // 기수 목록 조회
    @Override
    public List<CohortResponseDTO.CohortInfoDTO> getCohortList(){
        List<Cohort> cohorts = cohortRepository.findAll();

        return cohorts.stream()
                .map(CohortConverter::toCohortInfoDTO)
                .collect(Collectors.toList());
    }
}
