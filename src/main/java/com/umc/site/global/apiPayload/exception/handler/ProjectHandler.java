package com.umc.site.global.apiPayload.exception.handler;

import com.umc.site.global.apiPayload.code.BaseErrorCode;
import com.umc.site.global.apiPayload.exception.GeneralException;

public class ProjectHandler extends GeneralException {
    public ProjectHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
