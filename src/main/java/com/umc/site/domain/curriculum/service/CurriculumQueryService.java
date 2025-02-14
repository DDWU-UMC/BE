package com.umc.site.domain.curriculum.service;

import com.umc.site.domain.curriculum.dto.CurriculumResponseDTO;
import com.umc.site.domain.part.entity.enums.PartType;

import java.util.List;

public interface CurriculumQueryService {

    List<CurriculumResponseDTO.CurriculumInfoDTO> getCurriculumList(PartType partType);
}
