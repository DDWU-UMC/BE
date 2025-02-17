package com.umc.site.domain.project.service;

import com.umc.site.domain.feature.entity.Feature;
import com.umc.site.domain.feature.repository.FeatureRepository;
import com.umc.site.domain.image.entity.Image;
import com.umc.site.domain.image.repository.ImageRepository;
import com.umc.site.domain.project.converter.ProjectConverter;
import com.umc.site.domain.project.dto.ProjectResponseDTO;
import com.umc.site.domain.project.entity.Project;
import com.umc.site.domain.project.enums.ServiceType;
import com.umc.site.domain.project.repository.ProjectRepository;
import com.umc.site.domain.project.repository.ProjectRepositoryCustom;
import com.umc.site.global.apiPayload.code.status.ErrorStatus;
import com.umc.site.global.apiPayload.exception.handler.ProjectHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProjectQueryServiceImpl implements ProjectQueryService{
    private final ProjectRepository projectRepository;
    private final ImageRepository imageRepository;
    private final FeatureRepository featureRepository;
    private final ProjectRepositoryCustom projectRepositoryCustom;

    // 기수별 프로젝트 목록 조회
    @Override
    public List<ProjectResponseDTO.ProjectPreviewDTO> getProjectPreviewList(Long cohortId, ServiceType type, String keyword){

        List<Project> projects = projectRepositoryCustom.getProjects(cohortId, type, keyword);

        return projects.stream()
                .map(project -> {
                    Image image = imageRepository.findByProject(project);

                    return ProjectConverter.toProjectPreviewDTO(project, image);
                })
                .collect(Collectors.toList());
    }

    // 프로젝트 상세 정보 조회
    @Override
    public ProjectResponseDTO.ProjectDetailDTO getProjectDetails(Long projectId) {
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new ProjectHandler(ErrorStatus.PROJECT_NOT_FOUND));
        Image image = imageRepository.findByProject(project);
        List<Feature> features = featureRepository.findAllByProject(project);

        return ProjectConverter.toProjectDetailDTO(project, image, features);
    }

    // n기 다른 프로젝트 보기 목록 조회
    @Override
    public List<ProjectResponseDTO.OtherProjectDTO> getOtherProjects(Long projectId){
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectHandler(ErrorStatus.PROJECT_NOT_FOUND));

        Long cohortId = project.getCohort().getId();

        List<Project> otherProjects = projectRepository.findRandomProjectsByCohortId(cohortId, projectId);

        return otherProjects.stream()
                .map(projects -> {
                    Image image = imageRepository.findByProject(projects);
                    return ProjectConverter.toOtherProjectDTO(projects, image);
                })
                .collect(Collectors.toList());
    }
}
