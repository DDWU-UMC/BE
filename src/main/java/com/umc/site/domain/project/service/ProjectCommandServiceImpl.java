package com.umc.site.domain.project.service;


import com.umc.site.domain.cohort.entity.Cohort;
import com.umc.site.domain.cohort.repository.CohortRepository;
import com.umc.site.domain.feature.converter.FeatureConverter;
import com.umc.site.domain.feature.entity.Feature;
import com.umc.site.domain.feature.repository.FeatureRepository;
import com.umc.site.domain.image.converter.ImageConverter;
import com.umc.site.domain.image.repository.ImageRepository;
import com.umc.site.domain.image.service.ImageCommandService;
import com.umc.site.domain.project.converter.ProjectConverter;
import com.umc.site.domain.project.dto.ProjectRequestDTO;
import com.umc.site.domain.project.dto.ProjectResponseDTO;
import com.umc.site.domain.project.entity.Project;
import com.umc.site.domain.project.repository.ProjectRepository;
import com.umc.site.global.apiPayload.code.status.ErrorStatus;
import com.umc.site.global.apiPayload.exception.handler.ProjectHandler;
import com.umc.site.global.manager.AmazonS3Manager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ProjectCommandServiceImpl implements ProjectCommandService{

    private final ProjectRepository projectRepository;
    private final FeatureRepository featureRepository;
    private final CohortRepository cohortRepository;
    private final ImageCommandService imageCommandService;

    // 프로젝트 생성
    @Override
    @Transactional
    public ProjectResponseDTO.CreateProjectResultDTO createProject(ProjectRequestDTO.CreateProjectDTO request, MultipartFile file){
        
        // 프로젝트 기수 추가
        Cohort cohort = cohortRepository.findById(request.getCohortId())
                .orElseThrow(() -> new ProjectHandler(ErrorStatus.COHORT_NOT_FOUND));

        // 프로젝트 생성
        Project newProject = ProjectConverter.toProject(request, cohort);
        Project savedProject = projectRepository.save(newProject);

        // 핵심 기능 생성
        List<Feature> features = request.getFeatureList().stream()
                .map(featureDTO -> FeatureConverter.toFeature(featureDTO, savedProject))
                .collect(Collectors.toList());

        featureRepository.saveAll(features);

        // 이미지 저장
        imageCommandService.createProjectImage(file, savedProject);

        return ProjectConverter.toCreateProjectResultDTO(savedProject);
    }

    // 프로젝트 수정
    @Override
    @Transactional
    public ProjectResponseDTO.UpdateProjectResultDTO updateProject(Long projectId, ProjectRequestDTO.UpdateProjectDTO request, MultipartFile file){

        // 프로젝트 찾기
        Project existProject = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectHandler(ErrorStatus.PROJECT_NOT_FOUND));

        // 프로젝트 기수 찾기
        Cohort cohort = cohortRepository.findById(request.getCohortId())
                .orElseThrow(() -> new ProjectHandler(ErrorStatus.COHORT_NOT_FOUND));

        // 프로젝트 수정
        existProject.updateProject(request, cohort);

        // 새로운 핵심 기능 생성
        featureRepository.deleteAllByProjectId(projectId);  // 기존 핵심 기능 삭제
        List<Feature> features = request.getFeatureList().stream()
                .map(featureDTO -> FeatureConverter.toFeature(featureDTO, existProject))
                .collect(Collectors.toList());

        featureRepository.saveAll(features);

        // 새로운 이미지 저장 (이미지도 보냈을 때)
        if (file != null && !file.isEmpty()) {
            imageCommandService.deleteProjectImage(existProject);   // 기존 이미지 삭제
            imageCommandService.createProjectImage(file, existProject);
        }

        return ProjectConverter.toUpdateProjectResultDTO(existProject);
    }

    // 프로젝트 삭제
    @Override
    @Transactional
    public void deleteProject(Long projectId){

        // 프로젝트 찾기
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectHandler(ErrorStatus.PROJECT_NOT_FOUND));

        // 이미지 삭제
        imageCommandService.deleteProjectImage(project);
        
        projectRepository.delete(project);
    }
}
