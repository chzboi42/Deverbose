package com.chzboi42.deverbose;

public class Loops {

    private static int i;

    public static int i() {
        return i;
    }

    private static void forloop(int start, int end, int step, Runnable action) {
        i = start;
        if (step > 0) {
            for (int j = start; j < end; j += step) {
                action.run();
                i+=step;
            }
        }
        else if (step < 0) {
            for (int j = start; j > end; j += step) {
                action.run();
                i+=step;
            }
        } else {
            Console.println("Not a valid loop");
        }
    }

    public static void loop(int start, int end, int step, Runnable action) {
        forloop(start, end, step, action);
    }

    public static void loop(int end, Runnable action) {
        forloop(0,end,1, action);
    }

    public static void loop(int start, int end, Runnable action) {
        forloop(start, end, 1, action);
    }
}
