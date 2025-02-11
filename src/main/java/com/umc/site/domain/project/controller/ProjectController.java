package com.umc.site.domain.project.controller;

import com.umc.site.domain.project.dto.ProjectResponseDTO;
import com.umc.site.domain.project.service.ProjectQueryService;
import com.umc.site.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectQueryService projectQueryService;

    // 기수별 프로젝트 목록 조회
    @Operation(summary = "기수별 프로젝트 목록 조회", description = " 기수별 프로젝트 리스트를 불러옵니다.")
    @GetMapping("/projects/{cohortId}")
    @Parameters({
            @Parameter(name = "cohortId", description = "기수의 ID, path variable 입니다.")
    })
    public ApiResponse<List<ProjectResponseDTO.ProjectPreviewDTO>> getProjectPreviews(@PathVariable(name = "cohortId") Long cohortId) {

        return ApiResponse.onSuccess(projectQueryService.getProjectPreviewList(cohortId));
    }
}
