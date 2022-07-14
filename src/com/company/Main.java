package com.company;

import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        //create 1000 points
        int nrOfFeedPoints = 10000;
        PointsGenerator generator = new PointsGenerator();
        List<Point> pointList = generator.generatePoints(nrOfFeedPoints);

        //create new perceptron
        Perceptron perceptron = new Perceptron();

        //learn
        long sTime = System.currentTimeMillis();
        for (Point p : pointList){
            boolean teacherScore = verifierFunction(p);
            boolean perceptronScore = perceptron.perceptronFunction(p);
            if (teacherScore && !perceptronScore){perceptron.learningFunction(1);}
            if (!teacherScore && perceptronScore){perceptron.learningFunction(-1);}
        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - sTime;

        //test
        int nrOfTestPoints = 1000;
        List<Point> testPointList = generator.generatePoints(nrOfTestPoints);
        Stream<Boolean> scoresStream = Stream.empty();

        for (Point p : testPointList){
            boolean perceptronScore = perceptron.perceptronFunction(p);
            boolean verifierScore = verifierFunction(p);
            if (perceptronScore == verifierScore){
                scoresStream = Stream.concat(scoresStream, Stream.of(true));}
            else {
                scoresStream = Stream.concat(scoresStream, Stream.of(false));}
        }

        long score = scoresStream.filter(bool -> bool.equals(true)).count();

        //print result
        System.out.println("\nNr of learning iterations: " + nrOfFeedPoints);
        System.out.println("Learning time: " + totalTime + " milliseconds");
        System.out.println("\nCorrect answers: " + score + " out of " + nrOfTestPoints);
    }

    //verification function
    public static boolean verifierFunction (Point p) {
        return p.getY() > p.getX() * 2;
    }
}

