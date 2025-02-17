package com.umc.site.domain.part.repository;

import com.umc.site.domain.part.entity.Part;
import com.umc.site.domain.part.entity.enums.PartType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartRepository extends JpaRepository<Part, Long> {

    Part findByPartType(PartType partType);

    List<Part> findAllByIsRecruiting(Boolean isRecruiting);

}
