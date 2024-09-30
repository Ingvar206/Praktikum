package com.janeck.web.tools;
import org.springframework.stereotype.Component;

@Component
public class Surfacecalculator {


    public double calculateSquareArea(double squareSide) {
        return squareSide * squareSide;
    }

    public double calculateRectangleArea(double rectangleHeight, double rectangleWidth) {
        return rectangleHeight * rectangleWidth;
    }

    public double calculateTriangleArea(double triangleBase, double triangleHeight) {
        return 0.5 * triangleBase * triangleHeight;
    }

    public double calculateCircleArea(double circleRadius) {
        return Math.PI * circleRadius * circleRadius;
    }
}
