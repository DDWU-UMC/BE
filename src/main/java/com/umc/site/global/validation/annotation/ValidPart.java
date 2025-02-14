package com.umc.site.global.validation.annotation;

import com.umc.site.global.validation.validator.PartValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PartValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPart {

    String message() default "모집하지 않는 파트입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
