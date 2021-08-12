package com.alex.andreiev.geometry;

import lombok.Getter;

@Getter
public class Angle {

    int angle = 0;

    public Angle(int value) {
        setAngle(value);
    }

    public void setAngle(int value) {
        angle = (360+value) % 360;
//        int tmp = value % 360;
//        angle = tmp >= 0 ? tmp : 360+tmp;
    }

    public void addAngle(Angle angle) {
        setAngle(getAngle() + angle.getAngle());
    }

    public void subtractAngle(Angle angle) {
        setAngle(getAngle() - angle.getAngle());
    }

    public AngleType getAngleType() {
        if (angle == 0) return AngleType.ZERO;
        if (angle < 90) return AngleType.ACUTE;
        if (angle == 90) return AngleType.RIGHT;
        if (angle < 180) return AngleType.OBTUSE;
        if (angle == 180) return AngleType.STRAIGHT;
        else return AngleType.REFLEX;
    }

    public enum AngleType {
        ZERO,       // 0
        ACUTE,      // less than 90°
        RIGHT,      // exactly 90°
        OBTUSE,     // greater than 90°
        STRAIGHT,   // exactly 180°
        REFLEX      // greater than 180° and less than 360°
    }
}
