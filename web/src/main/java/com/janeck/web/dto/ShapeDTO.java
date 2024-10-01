package com.janeck.web.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class ShapeDTO {

    @NotNull(message = "Bitte wählen sie eine Form")
    private String shape;

    @Min(value = 0, message = "Die Eingabe muss zwischen 0 und 100 sein")
    @Max(value = 100, message = "Die Eingabe muss zwischen 0 und 100 sein")
    private Double squareSide;

    @Min(value = 0, message = "Die Eingabe muss zwischen 0 und 100 sein")
    @Max(value = 100, message = "Die Eingabe muss zwischen 0 und 100 sein")
    private Double rectangleHeight;

    @Min(value = 0, message = "Die Eingabe muss zwischen 0 und 100 sein")
    @Max(value = 100, message = "Die Eingabe muss zwischen 0 und 100 sein")
    private Double rectangleWidth;

    @Min(value = 0, message = "Die Eingabe muss zwischen 0 und 100 sein")
    @Max(value = 100, message = "Die Eingabe muss zwischen 0 und 100 sein")
    private Double triangleBase;

    @Min(value = 0, message = "Die Eingabe muss zwischen 0 und 100 sein")
    @Max(value = 100, message = "Die Eingabe muss zwischen 0 und 100 sein")
    private Double triangleHeight;

    @Min(value = 0, message = "Die Eingabe muss zwischen 0 und 50 sein")
    @Max(value = 50, message = "Die Eingabe muss zwischen 0 und 50 sein")
    private Double circleRadius;



    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public Double getSquareSide() {
        return squareSide;
    }

    public void setSquareSide(Double squareSide) {
        this.squareSide = squareSide;
    }

    public Double getRectangleHeight() {
        return rectangleHeight;
    }

    public void setRectangleHeight(Double rectangleHeight) {
        this.rectangleHeight = rectangleHeight;
    }

    public Double getRectangleWidth() {
        return rectangleWidth;
    }

    public void setRectangleWidth(Double rectangleWidth) {
        this.rectangleWidth = rectangleWidth;
    }

    public Double getTriangleBase() {
        return triangleBase;
    }

    public void setTriangleBase(Double triangleBase) {
        this.triangleBase = triangleBase;
    }

    public Double getTriangleHeight() {
        return triangleHeight;
    }

    public void setTriangleHeight(Double triangleHeight) {
        this.triangleHeight = triangleHeight;
    }

    public Double getCircleRadius() {
        return circleRadius;
    }

    public void setCircleRadius(Double circleRadius) {
        this.circleRadius = circleRadius;
    }
}

