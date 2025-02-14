package com.umc.site.domain.image.service;

import com.umc.site.domain.club_admin.entity.ClubAdmin;
import com.umc.site.domain.project.entity.Project;
import org.springframework.web.multipart.MultipartFile;

public interface ImageCommandService {

    // 프로젝트 사진 생성
    void createProjectImage(MultipartFile file, Project project);

    // 프로젝트 사진 삭제
    void deleteProjectImage(Project project);

    // 운영진 사진 생성
    void createClubAdminImage(MultipartFile file, ClubAdmin clubAdmin);
}
