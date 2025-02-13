package com.umc.site.domain.project.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.umc.site.domain.project.entity.Project;
import com.umc.site.domain.project.entity.QProject;
import com.umc.site.domain.project.enums.ServiceType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProjectRepositoryCustomImpl implements ProjectRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Project> getProjects(Long cohortId, ServiceType type, String keyword) {

        QProject project = QProject.project;
        BooleanBuilder builder = new BooleanBuilder();

        // 기수 조건 추가
        if(cohortId != null) {
            builder.and(project.cohort.id.eq(cohortId));
        }

        // 서비스 타입 조건 추가
        if(type != null && !type.equals(ServiceType.ALL)) {
            builder.and(project.serviceType.eq(type));
        }

        // 검색 키워드 조건 추가
        if(keyword != null && !keyword.trim().isEmpty()) {
            builder.and(project.title.containsIgnoreCase(keyword));
        }

        return queryFactory
                .selectFrom(project)
                .where(builder)
                .fetch();
    }
}
