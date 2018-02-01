package com.mounacheikhna.testexplore;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Enclosed.class)
public class ValidatorMixOnceAndParametrized {

    @RunWith(Parameterized.class)
    public static class ParametrizedPart {

        private Extra input;
        private boolean validationResult;
        private Validator validator;

        @Before
        public void setUp() {
            validator = new Validator();
        }

        @Parameterized.Parameters(name = "{index}: validate({0})={1}") // not sure about this notation ?
        public static List<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    { new Extra("integer", "1"), true}, {new Extra("boolean", "true"), true },
                    { new Extra("integer", "a1"), false}, {new Extra("boolean", "b1"), false }
            });
        }

        // this is not ideal ?
        public ParametrizedPart(Extra input, boolean validationResult) {
            this.input = input;
            this.validationResult = validationResult;
        }

        @Test
        public void testValidate() {
            assertEquals(validationResult, validator.validate(input));
        }
    }

    public static class NotParameterizedPart {

        @Test
        public void anotherTestMethod() {
            assertTrue(true);
        }
    }

}
