package com.chzboi42.deverbose;

import java.util.HashMap;
import java.util.Map;

public class Interpolator {
    private final Map<Double, Double> storage = new HashMap<>();
    private double[][] values;

    public Interpolator() {}

    public final void put(double x, double y) {
        storage.put(x, y);
    }

    public final double get(double x) {
        toArray();
        return Maths.lerp2d(values, x);
    }

    private void toArray() {
        values = new double[storage.size()][2];
        int i = 0;
        for (Map.Entry<Double, Double> entry : storage.entrySet()) {
            values[i][0] = entry.getKey();
            values[i][1] = entry.getValue();
            i++;
        }
    }
}
