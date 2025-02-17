package com.umc.site.domain.role_history.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class RoleHistoryRequestDTO {

    // 활동 이력 생성
    @Getter
    public static class CreateRoleHistoryDTO {

        @NotBlank
        private String content;
    }

    // 활동 이력 수정
    @Getter
    public static class UpdateRoleHistoryDTO {

        private Long roleHistoryId;

        private String content;
    }
}
