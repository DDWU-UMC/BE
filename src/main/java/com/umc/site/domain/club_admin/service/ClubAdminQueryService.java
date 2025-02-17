package com.umc.site.domain.club_admin.service;

import com.umc.site.domain.club_admin.dto.ClubAdminResponseDTO;

import java.util.List;

public interface ClubAdminQueryService {

    List<ClubAdminResponseDTO.ClubAdminInfoDTO> getClubAdminList();

}
