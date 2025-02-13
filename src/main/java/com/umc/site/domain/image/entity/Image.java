package com.umc.site.domain.image.entity;

import com.umc.site.domain.club_admin.entity.ClubAdmin;
import com.umc.site.domain.project.entity.Project;
import com.umc.site.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Image extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100, unique = true)
    private String uuid;

    @Column(nullable = false, length = 100)
    private String fileName;

    @Column(nullable = false, length = 300)
    private String fileUrl;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "club_admin_id", referencedColumnName = "id")
    private ClubAdmin clubAdmin;

    @Setter
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private Project project;
}
