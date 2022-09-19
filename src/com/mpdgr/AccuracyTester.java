package com.mpdgr;

import java.util.ArrayList;
import java.util.List;

class AccuracyTester {
    /**
     * Calculates average number of correct answers for
     *
     * @param instanceCount   given number of perceptron instances at
     * @param learnIterations given number of learning iterations
     */
    void testPerceptron(int instanceCount, int learnIterations) {
        List<Double> scores = new ArrayList<>();

        for (int i = 0; i < instanceCount; i++) {
            PerceptronController controller = new PerceptronController();
            long score = controller.runPerceptron(learnIterations);
            scores.add((double) score);
        }

        double mean = scores.stream().reduce(Double::sum).get() / instanceCount;
        double max = scores.stream().max(Double::compare).get();
        double min = scores.stream().min(Double::compare).get();

        System.out.println(
                "\n\nInstances: " + instanceCount + "; Learning iterations: " + learnIterations +
                        "\nMean nr of correct answers: " + mean + " in 1000" +
                        "\nMax correct answers: " + max +
                        "\nMin correct answers: " + min
        );
    }
}