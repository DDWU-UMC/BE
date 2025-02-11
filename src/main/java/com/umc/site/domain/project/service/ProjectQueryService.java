package com.umc.site.domain.project.service;

import com.umc.site.domain.project.dto.ProjectResponseDTO;

import java.util.List;

public interface ProjectQueryService {

    // 기수별 프로젝트 목록 조회
    List<ProjectResponseDTO.ProjectPreviewDTO> getProjectPreviewList(Long cohortId);

    // 프로젝트 상세 정보 조회
    ProjectResponseDTO.ProjectDetailDTO getProjectDetails(Long projectId);
}
