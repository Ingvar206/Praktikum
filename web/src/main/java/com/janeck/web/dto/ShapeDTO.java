package com.janeck.web.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class ShapeDTO {

    @NotNull(message = "Shape is required")
    private String shape;

    @Min(value = 0, message = "Value must be between 0 and 100")
    @Max(value = 100, message = "Value must be between 0 and 100")
    private Double squareSide;

    @Min(value = 0, message = "Value must be between 0 and 100")
    @Max(value = 100, message = "Value must be between 0 and 100")
    private Double rectangleHeight;

    @Min(value = 0, message = "Value must be between 0 and 100")
    @Max(value = 100, message = "Value must be between 0 and 100")
    private Double rectangleWidth;

    @Min(value = 0, message = "Value must be between 0 and 100")
    @Max(value = 100, message = "Value must be between 0 and 100")
    private Double triangleBase;

    @Min(value = 0, message = "Value must be between 0 and 100")
    @Max(value = 100, message = "Value must be between 0 and 100")
    private Double triangleHeight;

    @Min(value = 0, message = "Value must be between 0 and 50")
    @Max(value = 50, message = "Value must be between 0 and 50")
    private Double circleRadius;

    // Getter und Setter

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

