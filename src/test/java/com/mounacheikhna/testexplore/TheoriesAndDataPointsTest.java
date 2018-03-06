package com.mounacheikhna.testexplore;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeTrue;

@RunWith(Theories.class)
public class TheoriesAndDataPointsTest {

    @DataPoints("a values")
    public static int[] aValues() {
        // Use new Random().nextInt() to experiment:
        int[] ints = {1, 2};
        System.out.println("Generated test data: "+ Arrays.toString(ints));
        return ints;
    }

    @DataPoints("b values")
    public static int[] bValues() {
        // Generate dynamically:
        int[] ints = {3, 4};
        System.out.println("Generated test data: "
                + Arrays.toString(ints));
        return ints;
    }

    @Theory
    public void sumShouldBeCommutative(@FromDataPoints("a values") int a,
                                       @FromDataPoints("b values") int b) {
        System.out.printf("a = %d, b = %d%n", a, b);
        assertEquals(a + b, b + a);
    }

    @DataPoints
    public static List<String> languages() {
        List<String> languages = asList("Java", null, "", "Groovy");
        System.out.println("Generated languages: " + languages);
        return languages;
    }

    @Theory(nullsAccepted = false)
    public void shouldMinValue(String language) {
        // This will filter out empty strings:
        assumeTrue("Language must be non empty!", language.length() > 0);
        System.out.printf("Asserting language: '%s'%n", language);
        assertThat(language, containsString("v"));
    }

}
