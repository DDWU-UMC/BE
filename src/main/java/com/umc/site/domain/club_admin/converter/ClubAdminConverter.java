package com.umc.site.domain.club_admin.converter;

import com.umc.site.domain.club_admin.dto.ClubAdminResponseDTO;
import com.umc.site.domain.club_admin.entity.ClubAdmin;
import com.umc.site.domain.image.converter.ImageConverter;
import com.umc.site.domain.image.entity.Image;
import com.umc.site.domain.role_history.converter.RoleHistoryConverter;
import com.umc.site.domain.role_history.entity.RoleHistory;

import java.util.List;

public class ClubAdminConverter {

    public static ClubAdminResponseDTO.ClubAdminInfoDTO toClubAdminInfoDTO(ClubAdmin clubAdmin, Image image, List<RoleHistory> roleHistories) {

        return ClubAdminResponseDTO.ClubAdminInfoDTO.builder()
                .clubAdminId(clubAdmin.getId())
                .name(clubAdmin.getName())
                .nickname(clubAdmin.getNickname())
                .commitment(clubAdmin.getCommitment())
                .role(clubAdmin.getRole())
                .image(ImageConverter.toImageDTO(image))
                .roleHistories(roleHistories.stream()
                        .map(RoleHistoryConverter::toRoleHistoryDTO)
                        .toList())
                .build();
    }
}
