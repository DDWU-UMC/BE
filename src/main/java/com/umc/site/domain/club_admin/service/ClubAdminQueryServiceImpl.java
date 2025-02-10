package com.umc.site.domain.club_admin.service;

import com.umc.site.domain.club_admin.converter.ClubAdminConverter;
import com.umc.site.domain.club_admin.dto.ClubAdminResponseDTO;
import com.umc.site.domain.club_admin.entity.ClubAdmin;
import com.umc.site.domain.club_admin.repository.ClubAdminRepository;
import com.umc.site.domain.image.entity.Image;
import com.umc.site.domain.image.repository.ImageRepository;
import com.umc.site.domain.role_history.entity.RoleHistory;
import com.umc.site.domain.role_history.repository.RoleHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
                    Image image = imageRepository.findByClubAdmin(clubAdmin);
                    List<RoleHistory> roleHistories = roleHistoryRepository.findAllByClubAdmin(clubAdmin);

                    return ClubAdminConverter.toClubAdminInfoDTO(clubAdmin, image, roleHistories);
                })
                .collect(Collectors.toList());
    }

}
