package com.umc.site.global.apiPayload.code.status;

import com.umc.site.global.apiPayload.code.BaseErrorCode;
import com.umc.site.global.apiPayload.code.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
    // 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),

    // 파트 관련 에러
    PART_NOT_RECRUITNIG(HttpStatus.BAD_REQUEST, "PART4001", "모집 대상이 아닌 파트입니다."),
    INVALID_PART(HttpStatus.BAD_REQUEST, "PART4002", "올바르지 않은 파트입니다."),
  
    // 이미지 관련 에러
    IMAGE_NOT_FOUND(HttpStatus.NOT_FOUND, "IMAGE_NOT4001", "존재하지 않는 운영진 이미지입니다."),

    // 운영진 관련 에러
    CLUB_ADMIN_NOT_FOUND(HttpStatus.NOT_FOUND, "CLUB_ADMIN4001", "존재하지 않는 운영진입니다."),

    // 활동 이력 관련 에러
    ROLE_HISTORY_NOT_FOUND(HttpStatus.NOT_FOUND, "ROLE_HISTORY4001", "존재하지 않는 활동 이력입니다."),

    // 기수 관련 에러
    COHORT_NOT_FOUND(HttpStatus.NOT_FOUND, "COHORT4001", "존재하지 않는 기수입니다."),

    // 프로젝트 관련 에러
    PROJECT_NOT_FOUND(HttpStatus.NOT_FOUND, "PROJECT4001", "존재하지 않는 프로젝트입니다."),
    INVALID_SERVICE_TYPE(HttpStatus.BAD_REQUEST, "PROJECT4002", "올바르지 않은 서비스 타입입니다..");


    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }
    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build()
                ;
    }
}
