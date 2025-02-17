package com.umc.site.global.apiPayload.exception.handler;

import com.umc.site.global.apiPayload.code.BaseErrorCode;
import com.umc.site.global.apiPayload.exception.GeneralException;

public class ImageHandler extends GeneralException {
    public ImageHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
