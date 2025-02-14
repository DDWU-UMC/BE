package com.umc.site.domain.part.service;

import com.umc.site.domain.part.dto.PartResponseDTO;

import java.util.List;

public interface PartQueryService {

    List<PartResponseDTO.RecruitingPartDTO> getRecruitingPartList();
}
