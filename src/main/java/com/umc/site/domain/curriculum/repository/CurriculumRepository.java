package com.umc.site.domain.curriculum.repository;

import com.umc.site.domain.curriculum.entity.Curriculum;
import com.umc.site.domain.part.entity.Part;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurriculumRepository extends JpaRepository<Curriculum, Long> {

    List<Curriculum> findAllByPart(Part part);
}
