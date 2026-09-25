package com.chzboi42.deverbose;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.chzboi42.deverbose.arrays.ArrayUtil;

public class Interpolator {
    private final Map<Double, Double> storage = new HashMap<>();

    public Interpolator() {}

    public final void put(double x, double y) {
        storage.put(x, y);
    }

    @SuppressWarnings("null")
    public final double get(double x) {
        double[][] storageArray = Arrays.stream(ArrayUtil.fromMapT(storage))
                        .map(row -> Arrays.stream(row).mapToDouble(Double::doubleValue).toArray())
                        .toArray(double[][]::new);
        return Maths.lerp2d(storageArray, x);
    }

}
