package com.mpdgr;

import java.util.ArrayList;
import java.util.List;

public class PerceptronController {
    long runPerceptron(final int learnIterations) {

        //create the perceptron
        Perceptron perceptron = new Perceptron();

        //create points for training
        PointsGenerator generator = new PointsGenerator();
        List<Point> pointList = generator.generatePoints(learnIterations);

        //train the perceptron
        long sTime = System.currentTimeMillis();
        for (Point p : pointList){
            boolean teacherScore = verifierFunction(p);
            boolean perceptronScore = perceptron.perceptronFunction(p);
            if (teacherScore != perceptronScore) {
                double error = expectedOutput(p) - perceptron.netOutput(p);
                double xCorrection = p.getX() * error;
                double yCorrection = p.getY() * error;
                double biasCorrection = error;
                perceptron.learningFunction(xCorrection, yCorrection, biasCorrection);
            }
        }
        long endTime = System.currentTimeMillis();

        //log learning time
        long totalTime = endTime - sTime;

        //test with random points
        int nrOfTestPoints = 1000;
        List<Point> testPointList = generator.generatePoints(nrOfTestPoints);
        List<Integer> scoresList = new ArrayList<>();


        for (Point p : testPointList){
            boolean perceptronScore = perceptron.perceptronFunction(p);
            boolean verifierScore = verifierFunction(p);
            scoresList.add(perceptronScore == verifierScore ? 1 : 0);
        }

        long score = scoresList.stream().filter(i -> i.equals(1)).count();

        //print the results
        System.out.println(
                "\n\n\nCorrect answers: " + score + " out of " + nrOfTestPoints +
                "\n*********************************************" +
                "\nNr of learning iterations: " + learnIterations +
                "\nLearning time: " + totalTime + " milliseconds" +
                "\nFinal X weight: " + String.format("%.6f", perceptron.getWeightX()) +
                "\nFinal Y weight: " + String.format("%.6f", perceptron.getWeightY()) +
                "\nFinal bias value: " + String.format("%.6f", perceptron.getBias()) +
                "\n*********************************************" +
                "\nTry again? (y/n)"
        );

        return score;
    }

    //verification functions
    public static boolean verifierFunction (Point p) {
        return p.getX() * -2 + p.getY() - 50 > 0;
    }

    public static double expectedOutput (Point p) {
        return p.getX() * -2 + p.getY() - 50;
    }
}