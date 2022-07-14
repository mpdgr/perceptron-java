package com.company;

import java.util.Random;

public class Perceptron {
    private double weightX;
    private double weightY;
    private final double threshold;

    public Perceptron() {
        Random random = new Random();
        this.weightX = random.nextDouble();
        this.weightY = random.nextDouble();
        this.threshold = random.nextDouble();
    }

    public boolean perceptronFunction(Point point) {
        return point.getX() * weightX + point.getY() * weightY > threshold;
    }

    public void learningFunction(int score) {
        switch (score) {
            case  1:
                weightX += 0.001;
            case -1:
                weightX -= 0.001;
        }
    }

    public double getWeightX() {
        return weightX;
    }

    public double getWeightY() {
        return weightY;
    }
}
