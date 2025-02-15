package com.umc.site.domain.image.entity;

import com.umc.site.domain.club_admin.entity.ClubAdmin;
import com.umc.site.domain.project.entity.Project;
import com.umc.site.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@DynamicInsert
@DynamicUpdate
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Image extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false, length = 100, unique = true)
    private String uuid;

    @Setter
    @Column(nullable = false, length = 100)
    private String fileName;

    @Setter
    @Column(nullable = false, length = 300)
    private String fileUrl;

    @Setter
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_admin_id", referencedColumnName = "id")
    private ClubAdmin clubAdmin;

    @Setter
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private Project project;
}
