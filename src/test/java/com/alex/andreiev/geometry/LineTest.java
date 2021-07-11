package com.alex.andreiev.geometry;

import kotlin.collections.ArrayDeque;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

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
        checkAddPoint(line);
    }

    @Test
    void addPoints() {
        var line = new Line(new Point(0), new Point(8));
        var pointCollection = new ArrayList<Point>();
        pointCollection.add(new Point(4));
        pointCollection.add(new Point(-2));
        pointCollection.add(new Point(100));
        line.addPoints(pointCollection);
        checkAddPoint(line);
    }

    private void checkAddPoint(AbstractLine line) {
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
    void removePoint() {
        var line = new Line(new Point(0), new Point(8));
        assertThrows(RuntimeException.class, () -> line.removePoint(new Point(8)));
        line.addPoint(new Point(10));
        assertEquals(line.getPoints().size(), 3);
        line.removePoint(new Point(8));
        assertEquals(line.getPoints().size(), 2);
        var expectedCollection = new ArrayList<Point>();
        expectedCollection.add(new Point(0));
        expectedCollection.add(new Point(10));
        assertTrue(line.getPoints().containsAll(expectedCollection));
    }

    @Test
    void removePoints(){
        var line = new Line(new Point(0), new Point(8));
        line.addPoint(new Point(10));
        line.addPoint(new Point(2));
        var pontCollection = new ArrayList<Point>();
        pontCollection.add(new Point(0));
        pontCollection.add(new Point(2));
        line.removePoints(pontCollection);
        var points = line.getPoints();
        var actualArr = points.toArray(i -> new Point[points.size()]);
        assertArrayEquals(new Point[]{new Point(8), new Point(10)}, actualArr);
    }

    @Test
    void equals() {
        var line = new Line(new Point(0), new Point(8));
        assertNotEquals(line, new Line(new Point(0), new Point(9)));
        assertEquals(line, new Line(new Point(0), new Point(8)));
    }

    @Test
    void getSections() {
        var line = new Line(new Point(0), new Point(8));
        line.addPoint(new Point(4));
        line.addPoint(new Point(-2));
        line.addPoint(new Point(100));
        var lines = line.getSections();

        var incorrectSizeSet = new ArrayList<Line>();
        incorrectSizeSet.add(new Line(new Point(-2), new Point(0)));
        incorrectSizeSet.add(new Line(new Point(0), new Point(4)));
        incorrectSizeSet.add(new Line(new Point(4), new Point(8)));
        assertNotEquals(lines.size(), incorrectSizeSet.size());

        var incorrectSet = new ArrayList<Line>(incorrectSizeSet);
        incorrectSet.add(new Line(new Point(4), new Point(99)));
        assertEquals(lines.size(), incorrectSet.size());
        assertFalse(lines.containsAll(incorrectSet));

        var correctSet = new ArrayList<Line>(incorrectSizeSet);
        correctSet.add(new Line(new Point(8), new Point(100)));
        assertTrue(lines.containsAll(correctSet));
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