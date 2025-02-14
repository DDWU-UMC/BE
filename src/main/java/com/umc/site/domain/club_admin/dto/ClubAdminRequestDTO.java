package com.umc.site.domain.club_admin.dto;

import com.umc.site.domain.club_admin.entity.enums.Role;
import com.umc.site.domain.role_history.dto.RoleHistoryRequestDTO;
import com.umc.site.domain.role_history.entity.RoleHistory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.List;

public class ClubAdminRequestDTO {

    // 운영진 생성
    @Getter
    public static class CreateClubAdminDTO {

        // 이름
        @NotBlank
        private String name;

        // 닉네임
        @NotBlank
        private String nickname;

        // 한 줄 다짐
        @NotBlank
        private String commitment;

        // 역할
        @NotNull(message =
                "PRESIDENT/VICE_PRESIDENT/SPRING_BOOT_LEADER" +
                "/ANDROID_LEADER/WEB_LEADER/DESIGN_LEADER/PLAN_LEADER/" +
                "NODEJS_LEADER/IOS_LEADER/MANAGE_LEADER ")
        private Role role;

        @Size(min = 1)
        private List<RoleHistoryRequestDTO.CreateRoleHistoryDTO> roleHistoryList;
    }

    @Getter
    public static class UpdateClubAdminDTO {

        // 이름
        private String name;

        // 닉네임
        private String nickname;

        // 한 줄 다짐
        private String commitment;

        // 역할
        private Role role;

        // 활동 이력
        private List<RoleHistoryRequestDTO.UpdateRoleHistoryDTO> roleHistories;
    }


}
