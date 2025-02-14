package com.umc.site.domain.club_admin.controller;

import com.umc.site.domain.club_admin.dto.ClubAdminRequestDTO;
import com.umc.site.domain.club_admin.dto.ClubAdminResponseDTO;
import com.umc.site.domain.club_admin.service.ClubAdminCommandService;
import com.umc.site.domain.club_admin.service.ClubAdminQueryService;
import com.umc.site.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ClubAdminController {

    private final ClubAdminQueryService clubAdminQueryService;
    private final ClubAdminCommandService clubAdminCommandService;

    // 운영진 리스트 조회
    @Operation(summary = "운영진 리스트 조회", description = "운영진 리스트를 불러옵니다.")
    @GetMapping("/club-admins")
    public ApiResponse<List<ClubAdminResponseDTO.ClubAdminInfoDTO>> getClubAdmins() {

        return ApiResponse.onSuccess(clubAdminQueryService.getClubAdminList());
    }

    // 운영진 생성
    @Operation(summary = "운영진 생성", description = "운영진을 생성합니다.")
    @PostMapping(value = "club-admins", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ApiResponse<ClubAdminResponseDTO.CreateClubAdminResultDTO> createClubAdmin(@RequestPart("request") @Valid ClubAdminRequestDTO.CreateClubAdminDTO request,
                                                                                      @RequestPart("file") MultipartFile file) {

        return ApiResponse.onSuccess(clubAdminCommandService.createClubAdmin(request, file));
    }
}
