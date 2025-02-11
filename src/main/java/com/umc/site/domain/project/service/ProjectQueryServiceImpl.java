package com.umc.site.domain.project.service;

import com.umc.site.domain.image.entity.Image;
import com.umc.site.domain.image.repository.ImageRepository;
import com.umc.site.domain.project.converter.ProjectConverter;
import com.umc.site.domain.project.dto.ProjectResponseDTO;
import com.umc.site.domain.project.entity.Project;
import com.umc.site.domain.project.repository.ProjectRepository;
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

    // 기수별 프로젝트 목록 조회
    @Override
    public List<ProjectResponseDTO.ProjectPreviewDTO> getProjectPreviewList(Long cohortId){
        List<Project> projects = projectRepository.findAllByCohortId(cohortId);

        return projects.stream()
                .map(project -> {
                    Image image = imageRepository.findByProject(project);

                    return ProjectConverter.toProjectPreviewDTO(project, image);
                })
                .collect(Collectors.toList());
    }
}
