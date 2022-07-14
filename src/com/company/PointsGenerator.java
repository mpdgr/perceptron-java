package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PointsGenerator {

    public List<Point> generatePoints(int nrOfPoints) {
        Random random = new Random();
        List<Point> pointList = new ArrayList<>();
        for (int i = 0; i < nrOfPoints; i++) {
            pointList.add(new Point(random.nextDouble() * 100_000, random.nextDouble() * 100_000));
        }
        return pointList;
    }
}
