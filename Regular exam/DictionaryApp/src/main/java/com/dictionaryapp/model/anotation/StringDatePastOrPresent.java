package com.dictionaryapp.model.anotation;

import com.dictionaryapp.validation.StringDatePastOrPresentValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;

@Target(FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StringDatePastOrPresentValidator.class)
public @interface StringDatePastOrPresent {
    String message() default "Date is not in past or present!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
