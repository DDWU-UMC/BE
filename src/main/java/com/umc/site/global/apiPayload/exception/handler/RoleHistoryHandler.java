package com.umc.site.global.apiPayload.exception.handler;

import com.umc.site.global.apiPayload.code.BaseErrorCode;
import com.umc.site.global.apiPayload.exception.GeneralException;

public class RoleHistoryHandler extends GeneralException {
    public RoleHistoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }

}
