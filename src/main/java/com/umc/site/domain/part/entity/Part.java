package com.umc.site.domain.part.entity;

import com.umc.site.domain.part.entity.enums.PartType;
import com.umc.site.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

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
    @Column(columnDefinition = "VARCHAR(20)")
    private PartType partType;

    @Column(nullable = false, length = 200)
    private String introduce;

    @Column(nullable = false)
    @ColumnDefault("true")
    private Boolean isRecruiting;
}
