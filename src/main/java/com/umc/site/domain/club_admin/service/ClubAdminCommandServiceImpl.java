package com.umc.site.domain.club_admin.service;

import com.umc.site.domain.club_admin.converter.ClubAdminConverter;
import com.umc.site.domain.club_admin.dto.ClubAdminRequestDTO;
import com.umc.site.domain.club_admin.dto.ClubAdminResponseDTO;
import com.umc.site.domain.club_admin.entity.ClubAdmin;
import com.umc.site.domain.club_admin.repository.ClubAdminRepository;
import com.umc.site.domain.image.entity.Image;
import com.umc.site.domain.image.repository.ImageRepository;
import com.umc.site.domain.image.service.ImageCommandService;
import com.umc.site.domain.role_history.converter.RoleHistoryConverter;
import com.umc.site.domain.role_history.dto.RoleHistoryRequestDTO;
import com.umc.site.domain.role_history.entity.RoleHistory;
import com.umc.site.domain.role_history.repository.RoleHistoryRepository;
import com.umc.site.global.apiPayload.code.status.ErrorStatus;
import com.umc.site.global.apiPayload.exception.handler.ClubAdminHandler;
import com.umc.site.global.apiPayload.exception.handler.ImageHandler;
import com.umc.site.global.apiPayload.exception.handler.RoleHistoryHandler;
import com.umc.site.global.manager.AmazonS3Manager;
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
    private final ImageRepository imageRepository;
    private final ImageCommandService imageCommandService;
    private final AmazonS3Manager s3Manager;

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

    // 운영진 수정
    @Override
    @Transactional
    public ClubAdminResponseDTO.UpdateClubAdminResultDTO updateClubAdmin(Long clubAdminId, ClubAdminRequestDTO.UpdateClubAdminDTO request, MultipartFile file) {

        // clubAdminId로 운영진 조회
        ClubAdmin clubAdmin = clubAdminRepository.findById(clubAdminId)
                .orElseThrow(() -> new ClubAdminHandler(ErrorStatus.CLUB_ADMIN_NOT_FOUND));

        // 운영진 정보 업데이트
        if (request.getName() != null) {
            clubAdmin.setName(request.getName());
        }
        if (request.getNickname() != null) {
            clubAdmin.setNickname(request.getNickname());
        }
        if (request.getCommitment() != null) {
            clubAdmin.setCommitment(request.getCommitment());
        }
        if (request.getRole() != null) {
            clubAdmin.setRole(request.getRole());
        }

        if (file != null && !file.isEmpty()) {
            updateClubAdminImage(clubAdmin, file);
        }
        updateClubAdminRoleHistory(request);

        ClubAdmin updatedClubAdmin = clubAdminRepository.save(clubAdmin);

        Image image = imageRepository.findByClubAdmin(updatedClubAdmin)
                .orElseThrow(() -> new ImageHandler(ErrorStatus.IMAGE_NOT_FOUND));

        List<RoleHistory> roleHistories = roleHistoryRepository.findAllByClubAdmin(updatedClubAdmin);

        return ClubAdminConverter.toUpdateClubAdminResultDTO(updatedClubAdmin, image, roleHistories);
    }

    // 운영진 활동 이력 업데이트
    private void updateClubAdminRoleHistory(ClubAdminRequestDTO.UpdateClubAdminDTO request) {

        if (request.getRoleHistories() != null && !request.getRoleHistories().isEmpty()) {

            for (RoleHistoryRequestDTO.UpdateRoleHistoryDTO roleHistoryDTO : request.getRoleHistories()) {
                RoleHistory roleHistory = roleHistoryRepository.findById(roleHistoryDTO.getRoleHistoryId())
                        .orElseThrow(() -> new RoleHistoryHandler(ErrorStatus.ROLE_HISTORY_NOT_FOUND));

                roleHistory.setContent(roleHistoryDTO.getContent());

                roleHistoryRepository.save(roleHistory);
            }
        }
    }

    // 운영진 사진 업데이트
    private void updateClubAdminImage(ClubAdmin clubAdmin, MultipartFile file) {

        if (file != null && !file.isEmpty()) {
            Image existingImage = imageRepository.findByClubAdmin(clubAdmin)
                    .orElseThrow(() -> new ImageHandler(ErrorStatus.IMAGE_NOT_FOUND));

            // S3에서 기존 운영진 사진 삭제
            s3Manager.deleteFile(existingImage.getFileName());

            // DB에서 기존 운영진 사진 삭제
            imageRepository.delete(existingImage);
            imageRepository.flush();

            // DB에 새로 생성
            imageCommandService.createClubAdminImage(file, clubAdmin);
        }
    }
}
