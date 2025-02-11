package com.umc.site.domain.project.repository;

import com.umc.site.domain.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository  extends JpaRepository<Project, Long> {

    // 기수별 프로젝트 목록 조회
    List<Project> findAllByCohortId(Long cohortId);
}
