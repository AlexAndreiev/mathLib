package com.alex.andreiev.geometry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void negativeValues() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(-2, 3));
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(2, -3));
    }

    @Test
    void setWidth() {
        var rect = new Rectangle(2, 4);
        assertThrows(IllegalArgumentException.class, () -> rect.setHeight(-3));
        rect.setWidth(8);
        assertEquals(8, rect.getWidth());
    }

    @Test
    void setHeight() {
        var rect = new Rectangle(2, 4);
        assertThrows(IllegalArgumentException.class, () -> rect.setHeight(-3));
        rect.setHeight(8);
        assertEquals(8, rect.getHeight());
    }

    @Test
    void getPerimeter() {
        var rect = new Rectangle(2, 4);
        assertEquals(12, rect.getPerimeter());
    }

    @Test
    void getSquare() {
        var rect = new Rectangle(2, 4);
        assertEquals(8, rect.getSquare());
    }
}
