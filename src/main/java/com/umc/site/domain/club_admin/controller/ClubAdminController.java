package com.umc.site.domain.club_admin.controller;

import com.umc.site.domain.club_admin.dto.ClubAdminResponseDTO;
import com.umc.site.domain.club_admin.service.ClubAdminQueryService;
import com.umc.site.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ClubAdminController {

    private final ClubAdminQueryService clubAdminQueryService;

    @Operation(summary = "운영진 리스트 조회", description = "운영진 리스트를 불러옵니다.")
    @GetMapping("/club-admins")
    public ApiResponse<List<ClubAdminResponseDTO.ClubAdminInfoDTO>> getClubAdmins() {

        return ApiResponse.onSuccess(clubAdminQueryService.getClubAdminList());
    }
}
