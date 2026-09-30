package com.chzboi42.deverbose;

import java.util.Objects;
import java.util.function.Consumer;

import com.chzboi42.deverbose.arrays.ArrayUtil;

public class Loops {
    private Loops() {}

    private static void forloop(int start, int end, int step, Consumer<LoopObject<Double>> toRun) {
        LoopObject<Double> obj = new LoopObject<>();
        obj.setIterator(((Number) start).doubleValue());
        if (step > 0) {
            for (; obj.iterator() < end && !obj.shouldBreak; obj.setIterator(obj.iterator() + 1)) {
                toRun.accept(obj);
            }
        }
        else if (step < 0) {
            for (; obj.iterator() > end && !obj.shouldBreak; obj.setIterator(obj.iterator() + 1)) {
                toRun.accept(obj);
            }
        } else {
            Console.println("Not a valid loop");
        }
    }

    public static void loop(int start, int end, int step, Consumer<LoopObject<Double>> toRun) {
        forloop(start, end, step, toRun);
    }

    public static void loop(int end, Consumer<LoopObject<Double>> toRun) {
        forloop(0,end,1, toRun);
    }

    public static void loop(int start, int end, Consumer<LoopObject<Double>> toRun) {
        forloop(start, end, start < end ? 1 : -1 , toRun);
    }

    public static <T> void foreach(T[] array, Consumer<LoopObject<T>> toRun) {
        LoopObject<T> obj = new LoopObject<>();
        for (int i = 0; i < array.length; i++) {
            obj.setIterator(array[i]);
            toRun.accept(obj);
            array[i] = obj.iterator(); 
        }
    }

    public static <T> void foreach(int[] array, Consumer<LoopObject<Integer>> toRun) {
        foreach(ArrayUtil.box(array), toRun);
    }

    public static <T> void foreach(long[] array, Consumer<LoopObject<Long>> toRun) {
        foreach(ArrayUtil.box(array), toRun);
    }

    public static <T> void foreach(double[] array, Consumer<LoopObject<Double>> toRun) {
        foreach(ArrayUtil.box(array), toRun);
    }

    public static <T> void foreach(boolean[] array, Consumer<LoopObject<Boolean>> toRun) {
        foreach(ArrayUtil.box(array), toRun);
    }

    public static <T> void foreach(char[] array, Consumer<LoopObject<Character>> toRun) {
        foreach(ArrayUtil.box(array), toRun);
    }

    public static class LoopObject<T> {
        private T i = null;
        private boolean shouldBreak = false;

        private LoopObject() {}

        public T iterator() {
            return i;
        }

        public int iteratorAsInt() {
            try {
                return ((Number) Objects.requireNonNull(i)).intValue();
            } catch (ClassCastException | NullPointerException e) {
                throw new NumberFormatException("You are not looping through a list of numbers and therefore cannot use this method, as the elements in the loop cannot be parsed as a numberm!");
            }
        }

        public void setIterator(T i) {
            this.i = i;
        }

        public void Break() {
            shouldBreak = true;
        }

    }
}
