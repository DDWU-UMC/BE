package com.umc.site.domain.part.entity.enums;

import com.umc.site.global.apiPayload.code.status.ErrorStatus;
import com.umc.site.global.apiPayload.exception.handler.PartHandler;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum PartType {
    SPRING_BOOT("springboot"),
    NODEJS("nodejs"),
    WEB("web"),
    ANDROID("android"),
    IOS("ios"),
    PLAN("plan"),
    DESIGN("design");

    private final String lowerCasePartType;

    PartType(String partType) {
        this.lowerCasePartType = partType;
    }

    public static PartType fromLowerCasePartType(String lowerCasePartType) {
        return Arrays.stream(values())
                .filter(part -> part.getLowerCasePartType().equals(lowerCasePartType))
                .findFirst()
                .orElseThrow(() -> new PartHandler(ErrorStatus.INVALID_PART));
    }
}
