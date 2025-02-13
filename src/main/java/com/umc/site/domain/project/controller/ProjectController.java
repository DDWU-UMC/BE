package com.umc.site.domain.project.controller;

import com.umc.site.domain.project.dto.ProjectRequestDTO;
import com.umc.site.domain.project.dto.ProjectResponseDTO;
import com.umc.site.domain.project.service.ProjectCommandService;
import com.umc.site.domain.project.service.ProjectQueryService;
import com.umc.site.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectQueryService projectQueryService;
    private final ProjectCommandService projectCommandService;

    // 기수별 프로젝트 목록 조회
    @Operation(summary = "기수별 프로젝트 목록 조회", description = " 기수별 프로젝트 리스트를 불러옵니다.")
    @GetMapping("/projects")
    @Parameters({
            @Parameter(name = "cohortId", description = "기수의 ID, query variable 입니다.")
    })
    public ApiResponse<List<ProjectResponseDTO.ProjectPreviewDTO>> getProjectPreviews(@RequestParam(name = "cohortId") Long cohortId) {

        return ApiResponse.onSuccess(projectQueryService.getProjectPreviewList(cohortId));
    }

    // 프로젝트 상세 보기
    @Operation(summary = "프로젝트 상세 정보 조회", description = "프로젝트 상세 정보를 불러옵니다.")
    @GetMapping("/projects/{projectId}")
    @Parameters({
            @Parameter(name = "projectId", description = "프로젝트의 ID, pathVariable 입니다.")
    })
    public ApiResponse<ProjectResponseDTO.ProjectDetailDTO> getProjectDetails(@PathVariable(name = "projectId") Long projectId) {

        return ApiResponse.onSuccess(projectQueryService.getProjectDetails(projectId));
    }

    // n기 다른 프로젝트 보기 목록 조회
    @Operation(summary = "같은 기수 다른 프로젝트 목록 조회", description = "프로젝트 상세페이지 하단의 같은 기수의 다른 프로젝트를 랜덤으로 3개 불러옵니다.")
    @GetMapping("/projects/{projectId}/others")
    @Parameters({
            @Parameter(name = "projectId", description = "상세페이지 조회한 프로젝트의 ID, pathVariable 입니다.")
    })
    public ApiResponse<List<ProjectResponseDTO.OtherProjectDTO>> getOtherProjects(@PathVariable(name = "projectId") Long projectId) {

        return ApiResponse.onSuccess(projectQueryService.getOtherProjects(projectId));
    }
    
    // 프로젝트 생성
    @Operation(summary = "프로젝트 생성", description = "프로젝트를 생성합니다.")
    @PostMapping(value =  "/projects", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ApiResponse<ProjectResponseDTO.CreateProjectResultDTO> createProject(@RequestPart("request") @Valid ProjectRequestDTO.CreateProjectDTO request,
                                                                                @RequestPart("file") MultipartFile file) {

        return ApiResponse.onSuccess(projectCommandService.createProject(request, file));
    }
}
