package com.mpdgr;

import java.util.Random;

public class Perceptron {
    private double weightX;
    private double weightY;
    private double bias;
    private double learningRate;

    public Perceptron() {
        Random random = new Random();
        this.weightX = random.nextDouble();
        this.weightY = random.nextDouble();
        this.bias = 1;
        this.learningRate = 0.000001;
    }

    public boolean perceptronFunction(Point point) {
        return point.getX() * weightX + point.getY() * weightY - bias > 0;
    }

    public void learningFunction(double xCorrection, double yCorrection, double biasCorrection) {
        weightX += xCorrection * learningRate;
        weightY += yCorrection * learningRate;
        bias += biasCorrection * learningRate;
    }

    public double netOutput(Point point) {
        return point.getX() * weightX + point.getY() * weightY - bias;
    }

    //getters

    public double getWeightX() {
        return weightX;
    }

    public double getWeightY() {
        return weightY;
    }

    public double getBias() {
        return bias;
    }
}
