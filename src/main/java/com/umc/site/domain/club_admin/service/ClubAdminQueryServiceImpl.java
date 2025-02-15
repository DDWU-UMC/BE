package com.umc.site.domain.club_admin.service;

import com.umc.site.domain.club_admin.converter.ClubAdminConverter;
import com.umc.site.domain.club_admin.dto.ClubAdminResponseDTO;
import com.umc.site.domain.club_admin.entity.ClubAdmin;
import com.umc.site.domain.club_admin.repository.ClubAdminRepository;
import com.umc.site.domain.image.entity.Image;
import com.umc.site.domain.image.repository.ImageRepository;
import com.umc.site.domain.role_history.entity.RoleHistory;
import com.umc.site.domain.role_history.repository.RoleHistoryRepository;
import com.umc.site.global.apiPayload.code.status.ErrorStatus;
import com.umc.site.global.apiPayload.exception.handler.ImageHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClubAdminQueryServiceImpl implements ClubAdminQueryService{

    private final ClubAdminRepository clubAdminRepository;
    private final ImageRepository imageRepository;
    private final RoleHistoryRepository roleHistoryRepository;

    @Override
    public List<ClubAdminResponseDTO.ClubAdminInfoDTO> getClubAdminList() {

        List<ClubAdmin> clubAdmins = clubAdminRepository.findAll();

        return clubAdmins.stream()
                .map(clubAdmin -> {
                    String role = switch (clubAdmin.getRole()) {
                        case PRESIDENT -> "회장";
                        case VICE_PRESIDENT -> "부회장";
                        case MANAGE_LEADER -> "운영팀장";
                        case PLAN_LEADER -> "Plan 파트장";
                        case DESIGN_LEADER -> "Design 파트장";
                        case SPRING_BOOT_LEADER -> "SpringBoot 파트장";
                        case NODEJS_LEADER -> "Node.js 파트장";
                        case WEB_LEADER -> "Web 파트장";
                        case ANDROID_LEADER -> "Android 파트장";
                        case IOS_LEADER -> "IOS 파트장";
                    };

                    Image image = imageRepository.findByClubAdmin(clubAdmin)
                            .orElseThrow(() -> new ImageHandler(ErrorStatus.IMAGE_NOT_FOUND));

                    List<RoleHistory> roleHistories = roleHistoryRepository.findAllByClubAdmin(clubAdmin);

                    return ClubAdminConverter.toClubAdminInfoDTO(clubAdmin, image, roleHistories, role);
                })
                .collect(Collectors.toList());
    }

}
