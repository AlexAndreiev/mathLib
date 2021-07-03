package com.alex.andreiv.geometry;

import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Rectangle {

    @Min(value = 0, message = "width cannot be negative")
    private int width;
    @Min(value = 0, message = "height cannot be negative")
    private int height;

    public int getPerimeter() { return 2 * (width + height); }
    public int getSquare() { return width * height; }
}
