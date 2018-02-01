package com.mounacheikhna.testexplore;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class ValidatorTest {

    private Extra input;
    private boolean validationResult;
    private Validator validator;

    @Parameters(name = "{index}: validate({0})={1}") // not sure about this notation ?
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][]{
                { new Extra("integer", "1"), true}, {new Extra("boolean", "true"), true },
                { new Extra("integer", "a1"), false}, {new Extra("boolean", "b1"), false }
        });
    }

    // this is not ideal ?
    public ValidatorTest(Extra input, boolean validationResult) {
        this.input = input;
        this.validationResult = validationResult;
    }

    @Before
    public void setUp() {
        validator = new Validator();
    }

    @Test
    public void testValidate() {
        assertEquals(validationResult, validator.validate(input));
    }

}
