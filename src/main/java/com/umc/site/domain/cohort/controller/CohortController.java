package com.umc.site.domain.cohort.controller;

import com.umc.site.domain.cohort.dto.CohortResponseDTO;
import com.umc.site.domain.cohort.service.CohortQueryService;
import com.umc.site.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CohortController {
    private final CohortQueryService cohortQueryService;

    // 기수 목록 조회
    @Operation(summary = "기수 목록 조회", description = "프로젝트를 불러오기 위한 기수 리스트를 불러옵니다.")
    @GetMapping("/projects/cohort")
    public ApiResponse<List<CohortResponseDTO.CohortInfoDTO>> getCohorts() {

        return ApiResponse.onSuccess(cohortQueryService.getCohortList());
    }
}
