package com.umc.site.domain.role_history.converter;

import com.umc.site.domain.club_admin.entity.ClubAdmin;
import com.umc.site.domain.club_admin.entity.enums.Role;
import com.umc.site.domain.role_history.dto.RoleHistoryRequestDTO;
import com.umc.site.domain.role_history.dto.RoleHistoryResponseDTO;
import com.umc.site.domain.role_history.entity.RoleHistory;

public class RoleHistoryConverter {

    // 운영진 리스트 조회
    public static RoleHistoryResponseDTO.RoleHistoryDTO toRoleHistoryDTO(RoleHistory roleHistory) {

        return RoleHistoryResponseDTO.RoleHistoryDTO.builder()
                .id(roleHistory.getId())
                .content(roleHistory.getContent())
                .build();
    }

    // 활동 이력 생성
    public static RoleHistory toRoleHistory(RoleHistoryRequestDTO.CreateRoleHistoryDTO request, ClubAdmin clubAdmin) {
        return RoleHistory.builder()
                .content(request.getContent())
                .clubAdmin(clubAdmin)
                .build();
    }
}
