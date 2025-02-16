package com.umc.site.domain.cohort.controller;

import com.umc.site.domain.cohort.dto.CohortRequestDTO;
import com.umc.site.domain.cohort.dto.CohortResponseDTO;
import com.umc.site.domain.cohort.service.CohortCommandService;
import com.umc.site.domain.cohort.service.CohortQueryService;
import com.umc.site.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CohortController {
    private final CohortQueryService cohortQueryService;
    private final CohortCommandService cohortCommandService;

    // 기수 목록 조회
    @Operation(summary = "기수 목록 조회", description = "프로젝트를 불러오기 위한 기수 리스트를 불러옵니다.")
    @GetMapping("/projects/cohort")
    public ApiResponse<List<CohortResponseDTO.CohortInfoDTO>> getCohorts() {

        return ApiResponse.onSuccess(cohortQueryService.getCohortList());
    }

    // 기수 추가
    @Operation(summary = "기수 생성", description = "프로젝트 새 기수를 추가합니다.")
    @PostMapping("/projects/cohort")
    public ApiResponse<CohortResponseDTO.CreateCohortResultDTO> createCohort(@RequestBody @Valid CohortRequestDTO.CreateCohortDTO request) {

        return ApiResponse.onSuccess(cohortCommandService.createCohort(request));
    }

    // 기수 수정
    @Operation(summary = "기수 수정", description = "프로젝트 기존 기수를 수정합니다.")
    @PatchMapping("/projects/cohort/{cohortId}")
    @Parameters({
            @Parameter(name = "cohortId", description = "기수의 ID, cohortId 입니다.")
    })
    public ApiResponse<CohortResponseDTO.UpdateCohortResultDTO> updateCohort(@PathVariable(name = "cohortId") Long cohortId, @RequestBody @Valid CohortRequestDTO.UpdateCohortDTO request) {

        return ApiResponse.onSuccess(cohortCommandService.updateCohort(cohortId, request));
    }

    // 기수 삭제
    @Operation(summary = "기수 삭제", description = "프로젝트 기존 기수를 삭제합니다.")
    @DeleteMapping("/projects/cohort/{cohortId}")
    @Parameters({
            @Parameter(name = "cohortId", description = "기수의 ID, cohortId 입니다.")
    })
    public ApiResponse<Void> deleteCohort(@PathVariable(name = "cohortId") Long cohortId) {

        cohortCommandService.deleteCohort(cohortId);

        return ApiResponse.onSuccess(null);
    }
}
