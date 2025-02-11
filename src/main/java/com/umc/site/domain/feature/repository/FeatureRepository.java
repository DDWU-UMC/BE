package com.umc.site.domain.feature.repository;

import com.umc.site.domain.feature.entity.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureRepository extends JpaRepository<Feature, Long> {
}
