package com.alex.andreiv.geometry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Point2DTest {

    @Test
    void getY() {
        var point = new Point2D(2, 4);
        assertEquals(point.getY(), 4);
    }
}