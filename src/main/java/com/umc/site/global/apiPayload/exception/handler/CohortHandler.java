package com.umc.site.global.apiPayload.exception.handler;

import com.umc.site.global.apiPayload.code.BaseErrorCode;
import com.umc.site.global.apiPayload.exception.GeneralException;

public class CohortHandler extends GeneralException {
    public CohortHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
