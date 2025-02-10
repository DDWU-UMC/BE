package com.umc.site.domain.club_admin.dto;

import com.umc.site.domain.club_admin.enums.Role;
import com.umc.site.domain.image.dto.ImageResponseDTO;
import com.umc.site.domain.role_history.dto.RoleHistoryResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class ClubAdminResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ClubAdminInfoDTO {
        Long clubAdminId;
        String name;
        String nickname;
        String commitment;
        Role role;
        ImageResponseDTO.ImageDTO image;
        List<RoleHistoryResponseDTO.RoleHistoryDTO> roleHistories;
    }
}
