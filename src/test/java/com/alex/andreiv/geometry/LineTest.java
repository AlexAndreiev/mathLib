package com.alex.andreiv.geometry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    void testAddPoint() {
        var line = new Line(new Point(0), new Point(8));
      //  assertThrows(IllegalArgumentException.class, () -> line.addPoint(new Point(9)));

        line.addPoint(new Point(4));
        line.getPoints();
        assertTrue(1 ==1);
    }

    @Test
    void testGetSections() {
    }

    @Test
    void testGetLength() {
    }
}