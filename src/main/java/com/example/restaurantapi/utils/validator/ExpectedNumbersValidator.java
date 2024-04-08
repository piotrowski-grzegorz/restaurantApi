package com.example.restaurantapi.utils.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class ExpectedNumbersValidator implements ConstraintValidator<ExpectedNumbers, Integer> {
    private int[] expectedNumbers;
    @Override
    public void initialize(ExpectedNumbers expectedNumbers) {
        this.expectedNumbers = expectedNumbers.expectedNumbers();
    }
    @Override
    public boolean isValid(Integer fieldValue, ConstraintValidatorContext cxt) {
        return fieldValue == null || Arrays.stream(expectedNumbers)
                .boxed()
                .toList()
                .contains(fieldValue);
    }
}