package com.alex.andreiev.geometry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @Test
    void negativeValues() {
        assertThrows(IllegalArgumentException.class, () -> new Square(-4));
    }

    @Test
    void setWidth() {
        var square = new Square(4);
        assertEquals(4, square.getWidth());
        square.setWidth(8);
        assertEquals(8, square.getWidth());
        assertEquals(8, square.getHeight());
    }

    @Test
    void setHeight() {
        var square = new Square(4);
        assertEquals(4, square.getHeight());
        square.setHeight(8);
        assertEquals(8, square.getWidth());
        assertEquals(8, square.getHeight());
    }
}