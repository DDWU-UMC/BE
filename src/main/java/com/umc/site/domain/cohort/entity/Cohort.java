package com.umc.site.domain.cohort.entity;

import com.umc.site.domain.project.entity.Project;
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
public class Cohort extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 기수명 (ex. 7기)
    @Column(nullable = false, length = 20)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cohort")
    private List<Project> projects = new ArrayList<>();
}
