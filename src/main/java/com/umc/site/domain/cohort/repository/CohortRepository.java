package com.umc.site.domain.cohort.repository;

import com.umc.site.domain.cohort.entity.Cohort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CohortRepository extends JpaRepository<Cohort, Long> {
}
