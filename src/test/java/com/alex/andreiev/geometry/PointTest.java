package com.alex.andreiev.geometry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PointTest {

    @Test
    public void getX() {
        var point = new Point(2);
        assertEquals(point.getX(), 2);

        point = new Point(-4);
        assertEquals(point.getX(), -4);
    }

    @Test
    void cloneTest() {
        var point = new Point(2);
        var clonedPoint = (Point) point.clone();
        assertEquals(point.getX(), clonedPoint.getX());
        // make sure references are not equal
        assertTrue(point != clonedPoint);
    }

    @Test
    void equals() {
        var point1 = new Point(2);
        var point2 = new Point(2);
        // make sure references are not equal
        assertTrue(point1 != point2);
        // calls equals method
        assertEquals(point1, point2);
    }
}