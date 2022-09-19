package com.mpdgr;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This Perceptron implementation consists of a neuron which can be trained
 * to determine whether given point (x, y) is located above or below graph of f(x) = ax + b function.
 * Perceptron accuracy depends on number of learning iterations.
 * <p>
 * Input number of learning iterations to train the Perceptron and see how it performs -
 * after training it will be tested on 1000 random points.
 * <p>
 * This program uses f(x) = 2x + 50 function, point coordinates ranging from 0 to 100 and
 * random perceptron weights at the start.
 * <p>
 * Average accuracy:<br>
 * - 100 learning iterations: 67%<br>
 * - 1000 learning iterations: 96%<br>
 * - 10 000 learning iterations: 98.0%<br>
 * - 100 000 learning iterations: 98.5%<br>
 * - 1 000 000 learning iterations: 99.8%<br>
 * - 10 000 000 learning iterations: 99.98%
 */

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean tryAgain = true;

        while (tryAgain) {
            System.out.print("\nInput nr of learning iterations: ");
            int learnIterations;
            try {
                learnIterations = scanner.nextInt();
                if (learnIterations < 0 || learnIterations > 10_000_000){
                    throw new IllegalArgumentException();
                }
            } catch (InputMismatchException | IllegalArgumentException e){
                scanner.nextLine();
                System.out.println("Input integer >= 0 and <= 10 000 000");
                continue;
            }

            PerceptronController controller = new PerceptronController();
            controller.runPerceptron(learnIterations);

            scanner.nextLine();
            String continued = scanner.nextLine();
            if (continued.equals("n")) {
                tryAgain = false;
                scanner.close();
            }
        }
    }
}

