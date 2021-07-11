package com.alex.andreiev.geometry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    public void testGetX() {
        var point = new Point(2);
        assertEquals(point.getX(), 2);
    }
}