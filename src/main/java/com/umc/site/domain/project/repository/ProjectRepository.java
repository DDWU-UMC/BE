package com.umc.site.domain.project.repository;

import com.umc.site.domain.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository  extends JpaRepository<Project, Long> {

    // 기수별 프로젝트 목록 조회
    List<Project> findAllByCohortId(Long cohortId);

    // n기 다른 프로젝트 보기 목록 조회
    @Query("SELECT p FROM Project p WHERE p.cohort.id = :cohortId AND p.id <> :projectId ORDER BY FUNCTION('RAND') LIMIT 3")
    List<Project> findRandomProjectsByCohortId(@Param("cohortId") Long cohortId, @Param("projectId") Long projectId);
}
