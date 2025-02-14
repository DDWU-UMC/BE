package com.umc.site.domain.club_admin.service;

import com.umc.site.domain.club_admin.dto.ClubAdminRequestDTO;
import com.umc.site.domain.club_admin.dto.ClubAdminResponseDTO;
import org.springframework.web.multipart.MultipartFile;

public interface ClubAdminCommandService {

    // 운영진 생성
    ClubAdminResponseDTO.CreateClubAdminResultDTO createClubAdmin(ClubAdminRequestDTO.CreateClubAdminDTO request, MultipartFile file);
}
