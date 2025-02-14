package com.umc.site.domain.project.service;

import com.umc.site.domain.project.dto.ProjectRequestDTO;
import com.umc.site.domain.project.dto.ProjectResponseDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProjectCommandService {
    // 프로젝트 생성
    ProjectResponseDTO.CreateProjectResultDTO createProject(ProjectRequestDTO.CreateProjectDTO request, MultipartFile file);

    // 프로젝트 수정
    ProjectResponseDTO.UpdateProjectResultDTO updateProject(Long projectId, ProjectRequestDTO.UpdateProjectDTO request, MultipartFile file);
}
