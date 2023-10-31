package com.dictionaryapp.validation;

import com.dictionaryapp.model.anotation.StringDatePastOrPresent;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class StringDatePastOrPresentValidator implements ConstraintValidator<StringDatePastOrPresent, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value != null && !value.isBlank()) {
            LocalDate parse = LocalDate.parse(value);
            return parse.isBefore(LocalDate.now()) || parse.isEqual(LocalDate.now());
        }
        return false;
    }

    @Override
    public void initialize(StringDatePastOrPresent constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
