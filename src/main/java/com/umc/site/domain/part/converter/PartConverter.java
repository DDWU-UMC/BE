package com.umc.site.domain.part.converter;

import com.umc.site.domain.part.dto.PartResponseDTO;
import com.umc.site.domain.part.entity.Part;

public class PartConverter {

    public static PartResponseDTO.RecruitingPartDTO toRecruitingPartDTO (Part part) {

        String name = switch (part.getPartType()) {
            case SPRING_BOOT -> "SpringBoot";
            case IOS -> "IOS";
            case ANDROID -> "Android";
            case WEB -> "Web";
            case PLAN -> "Plan";
            case DESIGN -> "Design";
            case NODEJS -> "Node.js";
        };

        return PartResponseDTO.RecruitingPartDTO.builder()
                .partId(part.getId())
                .name(name)
                .partType(part.getPartType())
                .build();
    }
}
