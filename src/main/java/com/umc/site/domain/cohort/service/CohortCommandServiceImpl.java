package com.umc.site.domain.cohort.service;

import com.umc.site.domain.cohort.converter.CohortConverter;
import com.umc.site.domain.cohort.dto.CohortRequestDTO;
import com.umc.site.domain.cohort.dto.CohortResponseDTO;
import com.umc.site.domain.cohort.entity.Cohort;
import com.umc.site.domain.cohort.repository.CohortRepository;
import com.umc.site.domain.image.service.ImageCommandService;
import com.umc.site.domain.project.entity.Project;
import com.umc.site.domain.project.repository.ProjectRepository;
import com.umc.site.global.apiPayload.code.status.ErrorStatus;
import com.umc.site.global.apiPayload.exception.handler.CohortHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CohortCommandServiceImpl implements CohortCommandService {

    private final CohortRepository cohortRepository;
    private final ProjectRepository projectRepository;
    private final ImageCommandService imageCommandService;

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

    // 기수 삭제
    @Override
    @Transactional
    public void deleteCohort(Long cohortId){
        Cohort cohort = cohortRepository.findById(cohortId)
                .orElseThrow(() -> new CohortHandler(ErrorStatus.COHORT_NOT_FOUND));

        // 이미지 삭제
        List<Project> projects = cohort.getProjects();
        for (Project project : projects) {
            imageCommandService.deleteProjectImage(project);
        }

        // 프로젝트 삭제
        projectRepository.deleteByCohortId(cohortId);

        // Cohort 삭제
        cohortRepository.delete(cohort);
    }
}
