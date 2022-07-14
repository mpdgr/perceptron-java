package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;

public class PointsGenerator {

    public List<Point> generatePoints(int nrOfPoints) {

        //create 10000 random points range 0-10000
        Random random = new Random();
        DoubleStream randomStreamX = random.doubles(nrOfPoints);
        DoubleStream randomStreamY = random.doubles(nrOfPoints);

        //x values list
        List<Double> xList = new ArrayList<>();
        randomStreamX.map(d -> d * 100000).forEach(xList::add);

        //y values list
        List<Double> yList = new ArrayList<>();
        randomStreamY.map(d -> d * 100000).forEach(yList::add);

        //points list
        List<Point> pointList = new ArrayList<>();
        for (int i = 0; i < nrOfPoints; i++) {
            pointList.add(new Point(xList.get(i), yList.get(i)));
        }
        return pointList;
    }
}
