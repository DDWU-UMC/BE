package com.umc.site.domain.part.entity;

import com.umc.site.domain.curriculum.entity.Curriculum;
import com.umc.site.domain.part.entity.enums.PartType;
import com.umc.site.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Part extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(20)", unique = true)
    private PartType partType;

    @Column(nullable = false, length = 200)
    private String introduce;

    @Column(nullable = false)
    @ColumnDefault("true")
    private Boolean isRecruiting;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "part")
    private List<Curriculum> curriculums = new ArrayList<>();
}
