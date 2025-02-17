package com.umc.site.global.apiPayload.exception.handler;

import com.umc.site.global.apiPayload.code.BaseErrorCode;
import com.umc.site.global.apiPayload.exception.GeneralException;

public class ClubAdminHandler extends GeneralException {
    public ClubAdminHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
