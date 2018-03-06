package com.mounacheikhna.testexplore;

import org.junit.Before;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

@RunWith(Theories.class)
public class ContainerTest {

    private Container container;

    // is there a way to generate these left, right, t, b in a range instead of specifying them by hand ?
    // ideally returning in a range 0 -> l : 20 squares then each left, left + size length, top, top + size length
    @DataPoints("bounds")
    public static Rect[] bounds() {
        int[] lefts = {1296, 1224, 1440, 1080};
        int[] rights = {1296, 1440, -182, 182};
        int[] tops = {-182, 0, 182, 364};
        int[] bottoms = {0, 182, 364, 728};

        Rect[] rects = new Rect[4];
        for (int i = 0; i < 4; i++) {
            rects[i] = new Rect(lefts[i], tops[i], rights[i], bottoms[i]);
        }
        return rects;
    }

    @Before
    public void setUp() throws Exception {
        container = new Container();
        container.setContainerXOffset(10);
    }

    @Theory
    public void testLeft(@FromDataPoints("bounds") Rect bounds) {
        System.out.println("testLeft with left = " + bounds.left + ", right = " +
                bounds.right + ", top = " + bounds.top + ", bottom = " + bounds.bottom);

        assumeTrue("Bounds are valid", boundsValid(bounds));
        container.setBounds(bounds);
        container.show();
        Margin margin = container.getMargin();
        assertTrue(margin.left >= bounds.left);
        assertTrue(margin.right >= bounds.right);
    }

    private boolean boundsValid(Rect bounds) {
        return bounds.left < bounds.right && bounds.top < bounds.right;
    }

}
