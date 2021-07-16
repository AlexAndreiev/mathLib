package com.alex.andreiev.geometry;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
public class Rectangle {

    private double width;
    public void setWidth(double width) {
        if (width <= 0)
            throw new IllegalArgumentException("Width cannot be zero or negative");
        this.width = width;
    }

    private double height;
    public void setHeight(double height) {
        if (height <= 0)
            throw new IllegalArgumentException("Height cannot be zero or negative");
        this.height = height;
    }

    public Rectangle(double width, double height) {
        setWidth(width);
        setHeight(height);
    }

    public double getPerimeter() { return 2 * (width + height); }
    public double getSquare() { return width * height; }
}
