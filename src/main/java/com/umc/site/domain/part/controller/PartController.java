package com.umc.site.domain.part.controller;

import com.umc.site.domain.part.dto.PartResponseDTO;
import com.umc.site.domain.part.service.PartQueryService;
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
public class PartController {

    private final PartQueryService partQueryService;

    // 모집 중인 파트 목록 조회
    @Operation(summary = "모집 중인 파트 목록 조회", description = "커리큘럼 페이지에서 모집 중인 파트 목록을 불러옵니다.")
    @GetMapping("/curriculums/part")
    public ApiResponse<List<PartResponseDTO.RecruitingPartDTO>> getRecruitingParts() {

        return ApiResponse.onSuccess(partQueryService.getRecruitingPartList());
    }
}
