package com.umc.site.domain.curriculum.service;

import com.umc.site.domain.curriculum.converter.CurriculumConverter;
import com.umc.site.domain.curriculum.dto.CurriculumResponseDTO;
import com.umc.site.domain.curriculum.entity.Curriculum;
import com.umc.site.domain.curriculum.repository.CurriculumRepository;
import com.umc.site.domain.part.entity.Part;
import com.umc.site.domain.part.entity.enums.PartType;
import com.umc.site.domain.part.repository.PartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CurriculumQueryServiceImpl implements CurriculumQueryService {

    private final PartRepository partRepository;
    private final CurriculumRepository curriculumRepository;

    @Override
    public List<CurriculumResponseDTO.CurriculumInfoDTO> getCurriculumList(PartType partType) {

        Part part = partRepository.findByPartType(partType);

        List<Curriculum> curriculums = curriculumRepository.findAllByPart(part);

        return curriculums.stream()
                .map(CurriculumConverter::toCurriculumInfoDTO)
                .toList();
    }
}
