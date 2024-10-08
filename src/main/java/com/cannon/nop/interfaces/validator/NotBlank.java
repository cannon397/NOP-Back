package com.cannon.nop.interfaces.validator;


import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Constraint(validatedBy = NotBlank.NoBlankValidator.class)
@Target(FIELD)
@Retention(RUNTIME)
public @interface NotBlank {
    String message() default "필수 또는 질문 입력란은 비어있을 수 없습니다.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class NoBlankValidator implements ConstraintValidator<NotBlank, String> {

        @Override
        public void initialize(NotBlank constraintAnnotation) {
        }

        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {
            return !value.isEmpty();
        }
    }
}
