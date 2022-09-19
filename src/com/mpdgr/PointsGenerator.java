package com.mpdgr;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PointsGenerator {
    public List<Point> generatePoints(int nrOfPoints) {
        Random random = new Random();
        List<Point> pointList = new ArrayList<>();
        for (int i = 0; i < nrOfPoints; i++) {
            //x, y vales range from 0 to 100
            pointList.add(new Point(random.nextDouble() * 100, random.nextDouble() * 100));
        }
        return pointList;
    }
}
