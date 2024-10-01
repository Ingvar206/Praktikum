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
    public double calculateSquareCircumference(double squareSide) {
        return squareSide * 4;
    }
    public double calculateRectangleCircumference(double rectangleWidth, double rectangleHeight) {
        return (rectangleWidth + rectangleHeight) * 2;
    }
    public double calculateTriangleCircumference(double triangleHeight) {
        return triangleHeight * 3;
    }
    public double calculateCircleCircumference(double circleRadius) {
        return 2 * Math.PI * circleRadius;
    }
}
