package com.umc.site.domain.club_admin.service;

import com.umc.site.domain.club_admin.converter.ClubAdminConverter;
import com.umc.site.domain.club_admin.dto.ClubAdminRequestDTO;
import com.umc.site.domain.club_admin.dto.ClubAdminResponseDTO;
import com.umc.site.domain.club_admin.entity.ClubAdmin;
import com.umc.site.domain.club_admin.repository.ClubAdminRepository;
import com.umc.site.domain.image.service.ImageCommandService;
import com.umc.site.domain.role_history.converter.RoleHistoryConverter;
import com.umc.site.domain.role_history.entity.RoleHistory;
import com.umc.site.domain.role_history.repository.RoleHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClubAdminCommandServiceImpl implements ClubAdminCommandService{

    private final ClubAdminRepository clubAdminRepository;
    private final RoleHistoryRepository roleHistoryRepository;
    private final ImageCommandService imageCommandService;

    // 운영진 생성
    @Override
    @Transactional
    public ClubAdminResponseDTO.CreateClubAdminResultDTO createClubAdmin(ClubAdminRequestDTO.CreateClubAdminDTO request, MultipartFile file) {

        // 운영진 생성
        ClubAdmin savedClubAdmin = clubAdminRepository.save(ClubAdminConverter.toClubAdmin(request));

        // 활동 이력 생성
        List<RoleHistory> roleHistories = request.getRoleHistoryList().stream()
                .map(roleHistoryDTO -> RoleHistoryConverter.toRoleHistory(roleHistoryDTO, savedClubAdmin))
                .toList();
        roleHistoryRepository.saveAll(roleHistories);

        // 이미지 저장
        imageCommandService.createClubAdminImage(file, savedClubAdmin);

        return ClubAdminConverter.toCreateClubAdminResultDTO(savedClubAdmin);
    }
}
