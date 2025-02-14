package com.umc.site.domain.cohort.service;

import com.umc.site.domain.cohort.converter.CohortConverter;
import com.umc.site.domain.cohort.dto.CohortRequestDTO;
import com.umc.site.domain.cohort.dto.CohortResponseDTO;
import com.umc.site.domain.cohort.entity.Cohort;
import com.umc.site.domain.cohort.repository.CohortRepository;
import com.umc.site.global.apiPayload.code.status.ErrorStatus;
import com.umc.site.global.apiPayload.exception.handler.CohortHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CohortCommandServiceImpl implements CohortCommandService {

    private final CohortRepository cohortRepository;

    // 기수 추가
    @Override
    @Transactional
    public CohortResponseDTO.CreateCohortResultDTO createCohort(CohortRequestDTO.CreateCohortDTO request){
        Cohort cohort = CohortConverter.toCohort(request);

        cohort = cohortRepository.save(cohort);

        return CohortConverter.toCreateCohortResultDTO(cohort);
    }


    // 기수 수정
    @Override
    @Transactional
    public CohortResponseDTO.UpdateCohortResultDTO updateCohort(Long cohortId, CohortRequestDTO.UpdateCohortDTO request){
        Cohort cohort = cohortRepository.findById(cohortId)
                .orElseThrow(() -> new CohortHandler(ErrorStatus.COHORT_NOT_FOUND));

        cohort.setName(request.getName());

        cohort = cohortRepository.save(cohort);

        return CohortConverter.toUpdateCohortResultDTO(cohort);
    }
}
