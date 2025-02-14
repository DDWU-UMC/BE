package com.umc.site.domain.curriculum.controller;

import com.umc.site.domain.curriculum.dto.CurriculumResponseDTO;
import com.umc.site.domain.curriculum.service.CurriculumQueryService;
import com.umc.site.domain.part.entity.enums.PartType;
import com.umc.site.global.apiPayload.ApiResponse;
import com.umc.site.global.validation.annotation.ValidPart;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Validated
public class CurriculumController {

    private final CurriculumQueryService curriculumQueryService;

    // 파트별 커리큘럼 조회
    @Operation(summary = "파트별 커리큘럼 조회", description = "파트별 커리큘럼 리스트를 불러옵니다.")
    @GetMapping("/curriculums")
    @Parameters ({
            @Parameter(name = "partType", description = "커리큘럼의 파트를 특정합니다, query variable 입니다.")
    })
    public ApiResponse<List<CurriculumResponseDTO.CurriculumInfoDTO>> getCurriculums(@RequestParam(defaultValue = "PLAN") @ValidPart PartType partType) {

        return ApiResponse.onSuccess(curriculumQueryService.getCurriculumList(partType));
    }
}
