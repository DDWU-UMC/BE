package com.umc.site.domain.image.repository;

import com.umc.site.domain.club_admin.entity.ClubAdmin;
import com.umc.site.domain.image.entity.Image;
import com.umc.site.domain.project.entity.Project;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Long> {

    Optional<Image> findByClubAdmin(ClubAdmin clubAdmin);

    Image findByProject(Project project);

}
