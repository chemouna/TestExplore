package com.mounacheikhna.testexplore;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ValidatorFieldParametrizationTest {

    @Parameter
    public Extra input;

    @Parameter(1)
    public boolean validationResult;

    private Validator validator;

    @Parameters(name = "{index}: validate({0})={1}")
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Extra("integer", "1"), true}, {new Extra("boolean", "true"), true},
                {new Extra("integer", "a1"), false}, {new Extra("boolean", "b1"), false}
        });
    }

    @Before
    public void setUp() {
        validator = new Validator();
    }

    @Test
    public void testValidate() {
        assertEquals(validationResult, validator.validate(input));
    }

    @Test
    public void anotherTestMethod() {
        assertTrue(true);
    }

}
