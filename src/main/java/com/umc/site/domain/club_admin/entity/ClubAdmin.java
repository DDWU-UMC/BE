package com.umc.site.domain.club_admin.entity;

import com.umc.site.domain.club_admin.enums.Role;
import com.umc.site.domain.role_history.entity.RoleHistory;
import com.umc.site.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ClubAdmin extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    private String name;

    @Column(nullable = false, length = 10)
    private String nickname;

    @Column(nullable = false, length = 50)
    private String commitment;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(30)")
    private Role role;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clubAdmin")
    private List<RoleHistory> roleHistories = new ArrayList<>();
}
