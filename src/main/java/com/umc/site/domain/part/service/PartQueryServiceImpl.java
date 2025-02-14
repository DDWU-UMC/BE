package com.umc.site.domain.part.service;

import com.umc.site.domain.part.converter.PartConverter;
import com.umc.site.domain.part.dto.PartResponseDTO;
import com.umc.site.domain.part.entity.Part;
import com.umc.site.domain.part.repository.PartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PartQueryServiceImpl implements PartQueryService {

    private final PartRepository partRepository;

    @Override
    public List<PartResponseDTO.RecruitingPartDTO> getRecruitingPartList() {

        List<Part> parts = partRepository.findAllByIsRecruiting(true);

        return parts.stream()
                .map(PartConverter::toRecruitingPartDTO)
                .toList();
    }
}
