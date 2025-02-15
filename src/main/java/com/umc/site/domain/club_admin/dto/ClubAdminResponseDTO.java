package com.umc.site.domain.club_admin.dto;

import com.umc.site.domain.club_admin.entity.enums.Role;
import com.umc.site.domain.image.dto.ImageResponseDTO;
import com.umc.site.domain.role_history.dto.RoleHistoryResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class ClubAdminResponseDTO {

    // 운영진 리스트 조회
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ClubAdminInfoDTO {
        Long clubAdminId;
        String name;
        String nickname;
        String commitment;
        String role;
        ImageResponseDTO.ImageDTO image;
        List<RoleHistoryResponseDTO.RoleHistoryDTO> roleHistories;
    }

    // 운영진 생성 응답
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateClubAdminResultDTO {
        private Long clubAdminId;
        LocalDateTime createdAt;
    }

    // 운영진 수정 응답
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateClubAdminResultDTO {
        Long clubAdminId;
        String name;
        String nickname;
        String commitment;
        Role role;
        ImageResponseDTO.ImageDTO image;
        List<RoleHistoryResponseDTO.RoleHistoryDTO> roleHistories;
        LocalDateTime updatedAt;
    }
}
