package com.umc.site.domain.club_admin.converter;

import com.umc.site.domain.club_admin.dto.ClubAdminRequestDTO;
import com.umc.site.domain.club_admin.dto.ClubAdminResponseDTO;
import com.umc.site.domain.club_admin.entity.ClubAdmin;
import com.umc.site.domain.image.converter.ImageConverter;
import com.umc.site.domain.image.entity.Image;
import com.umc.site.domain.role_history.converter.RoleHistoryConverter;
import com.umc.site.domain.role_history.entity.RoleHistory;

import java.util.List;

public class ClubAdminConverter {

    // 운영진 리스트 조회
    public static ClubAdminResponseDTO.ClubAdminInfoDTO toClubAdminInfoDTO(ClubAdmin clubAdmin, Image image,
                                                                           List<RoleHistory> roleHistories, String role) {

        return ClubAdminResponseDTO.ClubAdminInfoDTO.builder()
                .clubAdminId(clubAdmin.getId())
                .name(clubAdmin.getName())
                .nickname(clubAdmin.getNickname())
                .commitment(clubAdmin.getCommitment())
                .role(role)
                .image(ImageConverter.toImageDTO(image))
                .roleHistories(roleHistories.stream()
                        .map(RoleHistoryConverter::toRoleHistoryDTO)
                        .toList())
                .build();
    }


    public static ClubAdmin toClubAdmin(ClubAdminRequestDTO.CreateClubAdminDTO request) {

        return ClubAdmin.builder()
                .name(request.getName())
                .nickname(request.getNickname())
                .role(request.getRole())
                .commitment(request.getCommitment())
                .build();
    }

    // 운영진 생성
    public static ClubAdminResponseDTO.CreateClubAdminResultDTO toCreateClubAdminResultDTO(ClubAdmin clubAdmin) {
        return ClubAdminResponseDTO.CreateClubAdminResultDTO.builder()
                .clubAdminId(clubAdmin.getId())
                .createdAt(clubAdmin.getCreatedAt())
                .build();
    }

    // 운영진 수정
    public static ClubAdminResponseDTO.UpdateClubAdminResultDTO toUpdateClubAdminResultDTO(ClubAdmin clubAdmin, Image image,
                                                                                           List<RoleHistory> roleHistories) {

        return ClubAdminResponseDTO.UpdateClubAdminResultDTO.builder()
                .clubAdminId(clubAdmin.getId())
                .role(clubAdmin.getRole())
                .name(clubAdmin.getName())
                .nickname(clubAdmin.getNickname())
                .commitment(clubAdmin.getCommitment())
                .image(ImageConverter.toImageDTO(image))
                .roleHistories(roleHistories.stream()
                        .map(RoleHistoryConverter::toRoleHistoryDTO)
                        .toList())
                .updatedAt(clubAdmin.getUpdatedAt())
                .build();
    }
}
