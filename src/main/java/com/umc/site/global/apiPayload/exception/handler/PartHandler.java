package com.umc.site.global.apiPayload.exception.handler;

import com.umc.site.global.apiPayload.code.BaseErrorCode;
import com.umc.site.global.apiPayload.exception.GeneralException;

public class PartHandler extends GeneralException {
    public PartHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
