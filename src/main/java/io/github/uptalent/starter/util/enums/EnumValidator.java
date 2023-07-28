package io.github.uptalent.starter.util.enums;

import io.github.uptalent.starter.util.exception.InvalidEnumValueException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class EnumValidator implements ConstraintValidator<EnumValue, String> {
    private Set<String> allowedValues;

    @Override
    public void initialize(EnumValue validEnumValue) {
        Class<? extends Enum<?>> enumClass = validEnumValue.enumClass();
        allowedValues = Arrays.stream(enumClass.getEnumConstants())
                .map(Enum::name)
                .collect(Collectors.toSet());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value != null && allowedValues.contains(value.toUpperCase())) {
            return true;
        } else {
            throw new InvalidEnumValueException("Invalid value: " + value);
        }
    }
}