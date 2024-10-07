package com.janeck.web.tools;

public class CalculationHistory {
    private String calculationType;
    private String shape;
    private double result;

    public CalculationHistory(String calculationType, String shape, double result) {
        this.calculationType = calculationType;
        this.shape = shape;
        this.result = result;
    }

    public String getCalculationType() {
        return calculationType;
    }

    public void setCalculationType(String calculationType) {
        this.calculationType = calculationType;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}