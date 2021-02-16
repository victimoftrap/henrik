package com.github.victimoftrap.henrik.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Documented
@Constraint(validatedBy = NotEmptyJsonValidator.class)
@Target(value = {ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotEmptyJson {
    String message() default "JSON event content is empty";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
