package com.alex.andreiev.geometry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    void getMinPoint() {
        var line = new Line(new Point(0), new Point(8));
        assertEquals(new Point(0), line.getMinPoint());
    }

    @Test
    void getMaxPoint() {
        var line = new Line(new Point(0), new Point(8));
        assertEquals(new Point(8), line.getMaxPoint());
    }

    @Test
    void addPoint() {
        var line = new Line(new Point(0), new Point(8));
        line.addPoint(new Point(4));
        line.addPoint(new Point(-2));
        line.addPoint(new Point(100));
        assertEquals(new Point(-2), line.getMinPoint());
        assertEquals(new Point(100), line.getMaxPoint());
        var points = line.getPoints();
        var actualArr = points.toArray(i -> new Point[points.size()]);
        assertArrayEquals(new Point[]{
                new Point(-2), new Point(0), new Point(4),
                new Point(8), new Point(100)},
                actualArr);
    }

    @Test
    void getSections() {
    }

    @Test
    void getLength() {
        var line = new Line(new Point(0), new Point(8));
        assertEquals(8, line.getLength());

        line = new Line(new Point(0), new Point(8));
        line.addPoint(new Point(4));
        line.addPoint(new Point(-2));
        line.addPoint(new Point(100));
        assertEquals(102, line.getLength());
    }
}