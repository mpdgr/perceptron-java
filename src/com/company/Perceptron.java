package com.company;

import java.util.Random;

public class Perceptron {
    Random random = new Random();
    double weightX = random.nextDouble();
    double initialWeightX = weightX;
    double weightY = random.nextDouble();
    double threshold = random.nextDouble();

    public boolean perceptronFunction(Point point) {
        return point.x * weightX + point.y * weightY > threshold;
    }

    public void learningFunction(int score) {
        switch (score) {
            case  1:
                weightX += 0.001;
            case -1:
                weightX -= 0.001;
        }
    }
}
