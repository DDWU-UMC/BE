package com.umc.site.domain.project.repository;

import com.umc.site.domain.project.entity.Project;
import com.umc.site.domain.project.enums.ServiceType;

import java.util.List;

public interface ProjectRepositoryCustom {

    // 프로젝트 목록 조회
    List<Project> getProjects(Long cohortId, ServiceType type, String keyword);
}
