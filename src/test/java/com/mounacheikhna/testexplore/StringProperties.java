package com.mounacheikhna.testexplore;


import static junit.framework.TestCase.assertEquals;

public class StringProperties {

    public void concatenationLength(String s1, String s2) {
        assertEquals(s1.length() + s2.length(), (s1 + s2).length());
    }

}
