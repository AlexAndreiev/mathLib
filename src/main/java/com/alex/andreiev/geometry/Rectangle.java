package com.alex.andreiev.geometry;

import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Rectangle {

    @Min(value = 0, message = "width cannot be negative")
    private double width;
    @Min(value = 0, message = "height cannot be negative")
    private double height;

    public double getPerimeter() { return 2 * (width + height); }
    public double getSquare() { return width * height; }
}
