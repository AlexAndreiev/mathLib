package com.alex.andreiev.geometry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AngleTest {

    @Test
    void setAngle() {
        var angle = new Angle(40);
        angle.setAngle(4);
        assertEquals(4, angle.getAngle());
    }

    @Test
    void addAngle() {
        var angle = new Angle(40);
        angle.addAngle(new Angle(50));
        assertEquals(90, angle.getAngle());
    }

    @Test
    void subtractAngle() {
        var angle = new Angle(40);
        angle.subtractAngle(new Angle(50));
        assertEquals(350, angle.getAngle());
    }

    @Test
    void getAngleType() {
        var angle = new Angle(0);
        assertEquals(Angle.AngleType.ZERO, angle.getAngleType());

        angle.setAngle(40);
        assertEquals(Angle.AngleType.ACUTE, angle.getAngleType());

        angle.setAngle(90);
        assertEquals(Angle.AngleType.RIGHT, angle.getAngleType());

        angle.setAngle(91);
        assertEquals(Angle.AngleType.OBTUSE, angle.getAngleType());

        angle.setAngle(180);
        assertEquals(Angle.AngleType.STRAIGHT, angle.getAngleType());

        angle.setAngle(190);
        assertEquals(Angle.AngleType.REFLEX, angle.getAngleType());
    }

    @Test
    void getAngle() {
        var angle = new Angle(40);
        assertEquals(40, angle.getAngle());
    }

}