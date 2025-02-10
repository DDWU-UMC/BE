package com.umc.site.domain.image.repository;

import com.umc.site.domain.club_admin.entity.ClubAdmin;
import com.umc.site.domain.image.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {

    Image findByClubAdmin(ClubAdmin clubAdmin);

}
