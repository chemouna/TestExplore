package com.mounacheikhna.testexplore;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.function.Function;
import java.util.stream.IntStream;

import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

@RunWith(Theories.class)
public class FizzBuzzTest {

    @DataPoints
    public static final int[] numbers = IntStream.range(1, 100).toArray();

    private final Function<Integer, String> unit = new FizzBuzzFunction();

    @Theory
    public void validOutputTheory(int number) {
        System.out.println("validOutputTheory called with number : "+ number);
        assertTrue("Output must be valid FizzBuzz", isValidFizzBuzz(unit.apply(number)));
    }

    @Theory
    public void fizzTheory(int number) {
        assumeTrue("Number is divisible by 3", isDivisibleBy(3, number));

        assertTrue("Output must contain 'Fizz'", unit.apply(number).contains("Fizz"));
    }

    @Theory
    public void buzzTheory(int number) {
        assumeTrue("Number is divisible by 5", isDivisibleBy(5, number));

        assertTrue("Output must contain 'Buzz'", unit.apply(number).contains("Buzz"));
    }

    @Theory
    public void numberTheory(int number) {
        String fizzbuzz = unit.apply(number);
        assumeTrue("Output is a number", isANumber(fizzbuzz));

        assertTrue(
                "Output must be string representation of input number",
                number == Integer.valueOf(fizzbuzz));
    }

    private boolean isDivisibleBy(int divisor, int number) {
        return (number % divisor) == 0;
    }

    private boolean isValidFizzBuzz(String candidate) {
        return candidate.equals("Fizz")
                || candidate.equals("Buzz")
                || candidate.equals("FizzBuzz")
                || isANumber(candidate);
    }

    private boolean isANumber(String candidate) {
        return candidate.chars().allMatch(Character::isDigit);
    }
}
