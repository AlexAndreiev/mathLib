package com.alex.andreiev.geometry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PointTest {

    @Test
    public void getX() {
        var point = new Point(2);
        assertEquals(point.getX(), 2);
    }

    @Test
    void cloneTest() {
    }

    @Test
    void equals() {
    }
}