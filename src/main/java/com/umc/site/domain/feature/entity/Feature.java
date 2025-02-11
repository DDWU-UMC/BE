package com.umc.site.domain.feature.entity;

import com.umc.site.domain.project.entity.Project;
import com.umc.site.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Feature extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 내용
    @Column(nullable = false, length = 200)
    private String content;

    // 프로젝트 (fk)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;
}
