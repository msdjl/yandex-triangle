package ru.yandex.triangle;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class TriangleTest {
    @Test
    public void testName() throws Exception {
        Rtriangle triangle = RTriangleProvider.getRtriangle();

        double[] lengthsOfSides = {
            getLength(triangle.getApexX1(), triangle.getApexY1(), triangle.getApexX2(), triangle.getApexY2()),
            getLength(triangle.getApexX2(), triangle.getApexY2(), triangle.getApexX3(), triangle.getApexY3()),
            getLength(triangle.getApexX3(), triangle.getApexY3(), triangle.getApexX1(), triangle.getApexY1())
        };

        Arrays.sort(lengthsOfSides);

        assertTrue("it's a triangle (each side has length > 0)", lengthsOfSides[0] > 0);

        double hypotenuseSqr = Math.pow(lengthsOfSides[2], 2);
        double sumOfCathetusSqrs = Math.pow(lengthsOfSides[0], 2) + Math.pow(lengthsOfSides[1], 2);
        double diff = Math.abs(hypotenuseSqr - sumOfCathetusSqrs);
        double precision = 0.0000000001;

        assertTrue("it's a right triangle (in accordance to c^2 = a^2 + b^2)", diff < precision);
    }

    double getLength(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
