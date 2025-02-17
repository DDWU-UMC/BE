package com.umc.site.domain.project.enums;

import lombok.Getter;


@Getter
public enum ServiceType {
    ALL("ALL"),
    WEB("WEB"),
    ANDROID("ANDROID"),
    IOS("IOS"),
    WEB_ANDROID("WEB/ANDROID"),
    WEB_IOS("WEB/IOS");

    private final String value;

    ServiceType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        if (this == WEB_ANDROID) {
            return "WEB/ANDROID";
        } else if (this == WEB_IOS) {
            return "WEB/IOS";
        }
        return value;
    }
}
