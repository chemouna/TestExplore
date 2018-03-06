package com.mounacheikhna.testexplore;


import java.util.function.Function;

public class FizzBuzzFunction implements Function<Integer, String> {

    @Override
    public String apply(Integer number) {
        if (isMultiple(number, 3)) {
            if (isMultiple(number, 5)) {
                return "FizzBuzz";
            } else {
                return "Fizz";
            }
        } else if (isMultiple(number, 5)) {
            return "Buzz";
        } else {
            return Integer.toString(number);
        }
    }

    private boolean isMultiple(int candidate, int multiplier) {
        return candidate % multiplier == 0;
    }

}
