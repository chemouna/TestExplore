package com.mounacheikhna.testexplore;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assume.assumeThat;

@RunWith(Theories.class)
public class UserTest {

    @DataPoint
    public static String GOOD_USERNAME = "username";

    @DataPoint
    public static String GOOD_USERNAME_SLASH = "username/username";

    @Theory
    public void filenameIncludesUsername(String username) {
        assumeThat(username, not(containsString("/")));
        assertThat(new User(username).configFileName(), containsString(username)); // config file name must contain username
    }
}
