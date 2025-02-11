package com.umc.site.domain.feature.repository;

import com.umc.site.domain.feature.entity.Feature;
import com.umc.site.domain.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeatureRepository extends JpaRepository<Feature, Long> {
    List<Feature> findAllByProject(Project project);
}
