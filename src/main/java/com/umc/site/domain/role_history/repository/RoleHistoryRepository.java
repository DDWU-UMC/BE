package com.umc.site.domain.role_history.repository;

import com.umc.site.domain.club_admin.entity.ClubAdmin;
import com.umc.site.domain.role_history.entity.RoleHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleHistoryRepository extends JpaRepository<RoleHistory, Long> {
    List<RoleHistory> findAllByClubAdmin(ClubAdmin clubAdmin);
}
