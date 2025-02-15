package com.umc.site.global.validation.validator;

import com.umc.site.domain.part.entity.enums.PartType;
import com.umc.site.domain.part.repository.PartRepository;
import com.umc.site.global.apiPayload.code.status.ErrorStatus;
import com.umc.site.global.validation.annotation.ValidPart;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PartValidator implements ConstraintValidator<ValidPart, PartType> {

    private final PartRepository partRepository;


    @Override
    public void initialize(ValidPart constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(PartType partType, ConstraintValidatorContext context) {

        boolean isValid = partRepository.findByPartType(partType).getIsRecruiting();

        if(!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.PART_NOT_RECRUITNIG.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
