package com.chzboi42.deverbose;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.BooleanSupplier;

import com.chzboi42.deverbose.units.Time;

/**
 * Class for printing to console, Lists, and String modification
 * @author JPSilver315
 * @since 2026 Feb 02
 * @version 0.1
 */
public class Console {

    private static final ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    /**
     * Shorter version of {@link java.io.PrintStream#println(Object)}
     * @param x the {@link #Object} to be printed
     */
    public static void println(Object x) {
        System.out.println(x);
    }

    /**
     * Shorter version of {@link java.io.PrintStream#print(Object)}
     * @param x the {@link #Object} to be printed
     */
    public static void print(Object x) {
        System.out.print(x);
    }

    public static void write(Object x) {
        System.out.print(x + "\n");
    }

    public static void printNull() {
        System.out.println("");
    }

    public static void printf(String format, Object... args) {
        System.out.printf(format, args);
    }

    public static String reverse(String x) {
        StringBuilder sb = new StringBuilder();
        Loops.loop(x.length()-1, -1, -1, () -> 
                    sb.append(x.charAt(Loops.i()))
        );
        return sb.toString();
    }

    public static void parallelInstant(Runnable... tasks) {
        for (Runnable task : tasks) {
            executor.submit(task);
        }
        executor.shutdown();
    }

    public static void parallel(Runnable... tasks) {
        parallelInstant(tasks);
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {}
    }

    public static void sequence(Runnable... tasks) {
        for (Runnable task : tasks) {
            task.run();
        }
    }

    public static void waitUntil(BooleanSupplier condition) {
        while (!condition.getAsBoolean()) {
            try {
                Thread.sleep(0,1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void wait(Time time) {
        try {
            if (time.inNanoSeconds() < 999999) {
                Thread.sleep(0, (int) time.inNanoSeconds());
            } else {
                Thread.sleep((long) time.inMilliseconds());
            }
        } catch (InterruptedException e) {}
    }

}
