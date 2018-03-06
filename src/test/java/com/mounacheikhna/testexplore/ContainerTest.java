package com.mounacheikhna.testexplore;

import org.junit.Before;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class ContainerTest {

    private Container container;

    // is there a way to generate these left, right, t, b in a range instead of specifying them by hand ?
    @DataPoints
    public static final Rect[] bounds = new Rect[] {
            new Rect(691, -182, 800, 102),
            new Rect(500, -122, 500, 82),
            new Rect(391, -101, 300, 162),
            new Rect(481, -143, 200, 172)
    };

    @Before
    public void setUp() throws Exception {
        container = new Container();
    }

    @Theory
    public void testLeft(Rect bounds) {
        container.setBounds(bounds);
    }

}
