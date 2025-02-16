package com.umc.site.domain.project.entity;

import com.umc.site.domain.project.dto.ProjectRequestDTO;
import com.umc.site.domain.project.enums.ServiceType;
import com.umc.site.domain.cohort.entity.Cohort;
import com.umc.site.domain.feature.entity.Feature;
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
public class Project extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 프로젝트명
    @Column(nullable = false, length = 20)
    private String title;

    // 기획 사람들
    @Column(length = 100)
    private String pm;

    // 프론트엔드 사람들
    @Column(length = 100)
    private String frontEnd;

    // 백엔드 사람들
    @Column(length = 100)
    private String backEnd;

    // 디자인 사람들
    @Column(length = 100)
    private String design;

    // 서비스 유형
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(30)")
    private ServiceType serviceType;

    // 프로젝트 설명
    @Column(length = 200)
    private String description;

    // 프로젝트 한 줄 소개
    @Column(nullable = false, length = 200)
    private String introduction;

    // 프로젝트 핵심 기능
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private List<Feature> features = new ArrayList<>();

    // 기수 (fk)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cohort_id")
    private Cohort cohort;

    public void updateProject(ProjectRequestDTO.UpdateProjectDTO request, Cohort cohort) {
        this.title = request.getTitle();
        this.pm = request.getPm();
        this.frontEnd = request.getFrontEnd();
        this.backEnd = request.getBackEnd();
        this.design = request.getDesign();
        this.serviceType = request.getServiceType();
        this.description = request.getDescription();
        this.introduction = request.getIntroduction();
        this.cohort = cohort;
    }
}
