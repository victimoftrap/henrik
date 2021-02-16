package com.github.victimoftrap.henrik.validation;

import com.fasterxml.jackson.databind.JsonNode;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotEmptyJsonValidator implements ConstraintValidator<NotEmptyJson, Object> {
    @Override
    public boolean isValid(final Object jsonNode, final ConstraintValidatorContext validatorContext) {
        final var content = (JsonNode) jsonNode;
        return content != null && !content.isNull() && !content.isEmpty();
    }
}
