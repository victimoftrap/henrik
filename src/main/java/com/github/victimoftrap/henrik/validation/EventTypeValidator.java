package com.github.victimoftrap.henrik.validation;

import com.github.victimoftrap.henrik.model.EventType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.StringJoiner;

public class EventTypeValidator implements ConstraintValidator<ValidEventType, String> {
    private String exceptionMessage;

    @Override
    public void initialize(final ValidEventType constraintAnnotation) {
        var joiner = new StringJoiner(", ");
        Arrays.stream(EventType.values())
                .forEach(type -> joiner.add(type.getName()));
        exceptionMessage = String.format(constraintAnnotation.message(), joiner.toString());
    }

    @Override
    public boolean isValid(final String eventType, final ConstraintValidatorContext validatorContext) {
        validatorContext.disableDefaultConstraintViolation();
        validatorContext
                .buildConstraintViolationWithTemplate(exceptionMessage)
                .addConstraintViolation();

        return Arrays.stream(EventType.values())
                .anyMatch(instance -> instance.name().equalsIgnoreCase(eventType));
    }
}
