package com.alex.andreiev.geometry;

import kotlin.collections.ArrayDeque;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    void getMinPoint() {
        var line = new Line(new Point(0, "A"), new Point(8, "B"));
        assertEquals(new Point(0, "A"), line.getMinPoint());
    }

    @Test
    void getMaxPoint() {
        var line = new Line(new Point(0, "A"), new Point(8, "B"));
        assertEquals(new Point(8, "B"), line.getMaxPoint());
    }

    @Test
    void addPoint() {
        var line = new Line(new Point(0, "A"), new Point(8, "B"));
        line.addPoint(new Point(4, "C"));
        line.addPoint(new Point(-2, "D"));
        line.addPoint(new Point(100, "E"));
        checkAddPoint(line);
    }

    @Test
    void addPoints() {
        var line = new Line(new Point(0, "A"), new Point(8, "B"));
        var pointCollection = new ArrayList<Point>();
        pointCollection.add(new Point(4, "C"));
        pointCollection.add(new Point(-2, "D"));
        pointCollection.add(new Point(100, "E"));
        line.addPoints(pointCollection);
        checkAddPoint(line);
    }

    private void checkAddPoint(AbstractLine line) {
        assertEquals(new Point(-2, "A"), line.getMinPoint());
        assertEquals(new Point(100, "E"), line.getMaxPoint());
        var points = line.getPoints();
        var actualArr = points.toArray(i -> new Point[points.size()]);
        assertArrayEquals(new Point[]{
                        new Point(-2, "A"), new Point(0, "B"), new Point(4, "C"),
                        new Point(8, "D"), new Point(100, "E")},
                actualArr);
    }

    @Test
    void removePoint() {
        var line = new Line(new Point(0, "A"), new Point(8, "B"));
        assertThrows(RuntimeException.class, () -> line.removePoint(new Point(8, "B")));
        line.addPoint(new Point(10, "C"));
        assertEquals(line.getPoints().size(), 3);
        line.removePoint(new Point(8, "B"));
        assertEquals(line.getPoints().size(), 2);
        var expectedCollection = new ArrayList<Point>();
        expectedCollection.add(new Point(0, "A"));
        expectedCollection.add(new Point(10, "C"));
        assertTrue(line.getPoints().containsAll(expectedCollection));
    }

    @Test
    void removePoints(){
        var line = new Line(new Point(0, "A"), new Point(8, "B"));
        line.addPoint(new Point(10, "C"));
        line.addPoint(new Point(2, "D"));
        var pontCollection = new ArrayList<Point>();
        pontCollection.add(new Point(0, "A"));
        pontCollection.add(new Point(2, "D"));
        line.removePoints(pontCollection);
        var points = line.getPoints();
        var actualArr = points.toArray(i -> new Point[points.size()]);
        assertArrayEquals(new Point[]{new Point(8, "B"), new Point(10, "C")}, actualArr);
    }

    @Test
    void equals() {
        var line = new Line(new Point(0, "A"), new Point(8, "B"));
        assertNotEquals(line, new Line(new Point(0, "A"), new Point(9, "C")));
        assertEquals(line, new Line(new Point(0, "A"), new Point(8, "B")));
    }

    @Test
    void getSections() {
        var line = new Line(new Point(0, "A"), new Point(8, "B"));
        line.addPoint(new Point(4, "C"));
        line.addPoint(new Point(-2, "D"));
        line.addPoint(new Point(100, "E"));
        var lines = line.getSections();

        var incorrectSizeSet = new ArrayList<Line>();
        incorrectSizeSet.add(new Line(new Point(-2, "A"), new Point(0, "B")));
        incorrectSizeSet.add(new Line(new Point(0, "B"), new Point(4, "C")));
        incorrectSizeSet.add(new Line(new Point(4, "C"), new Point(8, "D")));
        assertNotEquals(lines.size(), incorrectSizeSet.size());

        var incorrectSet = new ArrayList<Line>(incorrectSizeSet);
        incorrectSet.add(new Line(new Point(4, "A"), new Point(99, "B")));
        assertEquals(lines.size(), incorrectSet.size());
        assertFalse(lines.containsAll(incorrectSet));

        var correctSet = new ArrayList<Line>(incorrectSizeSet);
        correctSet.add(new Line(new Point(8, "A"), new Point(100, "B")));
        assertTrue(lines.containsAll(correctSet));
    }

    @Test
    void getLength() {
        var line = new Line(new Point(0, "A"), new Point(8, "B"));
        assertEquals(8, line.getLength());

        line = new Line(new Point(0, "A"), new Point(8, "B"));
        line.addPoint(new Point(4, "C"));
        line.addPoint(new Point(-2, "D"));
        line.addPoint(new Point(100, "E"));
        assertEquals(102, line.getLength());
    }
}