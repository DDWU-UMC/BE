package com.umc.site.domain.project.service;

import com.umc.site.domain.project.dto.ProjectResponseDTO;
import com.umc.site.domain.project.enums.ServiceType;

import java.util.List;

public interface ProjectQueryService {

    // 기수별 프로젝트 목록 조회
    List<ProjectResponseDTO.ProjectPreviewDTO> getProjectPreviewList(Long cohortId, ServiceType type, String keyword);

    // 프로젝트 상세 정보 조회
    ProjectResponseDTO.ProjectDetailDTO getProjectDetails(Long projectId);

    // n기 다른 프로젝트 보기 목록 조회
    List<ProjectResponseDTO.OtherProjectDTO> getOtherProjects(Long projectId);
}
