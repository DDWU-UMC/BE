package com.umc.site.domain.role_history.converter;

import com.umc.site.domain.role_history.dto.RoleHistoryResponseDTO;
import com.umc.site.domain.role_history.entity.RoleHistory;

public class RoleHistoryConverter {

    public static RoleHistoryResponseDTO.RoleHistoryDTO toRoleHistoryDTO(RoleHistory roleHistory) {

        return RoleHistoryResponseDTO.RoleHistoryDTO.builder()
                .id(roleHistory.getId())
                .content(roleHistory.getContent())
                .build();
    }


}
