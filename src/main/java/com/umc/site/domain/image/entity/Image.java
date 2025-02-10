package com.umc.site.domain.image.entity;

import com.umc.site.domain.club_admin.entity.ClubAdmin;
import com.umc.site.domain.image.enums.ImageableType;
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

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(20)")
    private ImageableType imageableType;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "club_admin_id", referencedColumnName = "id")
    private ClubAdmin clubAdmin;
}
