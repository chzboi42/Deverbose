package com.chzboi42.deverbose;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chzboi42.deverbose.units.Angle;
import com.chzboi42.deverbose.units.Angle.Radians;

/**
 * Class for math-related stuff
 * @author JPSilver315
 * @since 2026 Feb 26
 * @version 0.3
 */
public class Maths {

    public static final double PI = 3.14159265358979323846264338327950288419716939937510582;
    public static final double TWO_PI = 2*PI;
    public static final double TAU = TWO_PI;
    public static final double HALF_PI = PI/2;
    public static final double QUARTER_PI = PI/4;

    public static final double E = 2.71828182845904523536;
    public static final double GOLDEN_RATIO = (1 + Math.sqrt(5)) / 2;

    /**
     * Checks if a number is between two numbers (included)
     * @param number the number
     * @param min the lower limit (included as part of the check)
     * @param max the upper limit (included as part of the check)
     * @return if the number is between (including) two other numbers
     */
    public static boolean isBetween(int number, int min, int max) {
        return number >= min && number <= max;
    }

    /**
     * Gets the largest integer in an array
     * @param array the array
     * @return the largest integer in the array
     */
    public static int getLargest(int[] array) {
        int largest = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > largest) {
                largest = array[i];
            }
        }
        return largest;
    }

    /**
     * Gets the largest double in an array
     * @param array the array
     * @return the largest double in the array
     */
    public static double getLargest(double[] array) {
        double largest = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > largest) {
                largest = array[i];
            }
        }
        return largest;
    }

    /**
     * Gets the smallest integer in an array
     * @param array the array
     * @return the smallest integer in the array
     */
    public static int getSmallest(int[] array) {
        int smallest = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
            }
        }
        return smallest;
    }

    /**
     * Gets the smallest double in an array
     * @param array the array
     * @return the smallest double in the array
     */
    public static double getSmallest(double[] array) {
        double smallest = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
            }
        }
        return smallest;
    }

    /**
     * Gets the mode of an array 
     * 
     * Not recommended, as this method only returns ONE mode, even if the array has multiple modes
     * 
     * @param dataset the array
     * @return one mode in the array
     */
    public static double getMode(double[] dataset) {
        Map<Double, Integer> frequency = new HashMap<>();
        for (double value : dataset) {
            frequency.put(value, frequency.getOrDefault(value, 0) + 1);
        }
        double mode = dataset[0];
        int maxCount = 0;
        for (var entry : frequency.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mode = entry.getKey();
            }
        }
        return mode;
    }

    /**
     * Gets ALL modes in an array
     * @param dataset the array
     * @return all modes in the array, even if it has multiple modes
     */
    public static List<Double> getModes(double[] dataset) {
        Map<Double, Integer> frequency = new HashMap<>();
        for (double value : dataset) {
            frequency.put(value, frequency.getOrDefault(value, 0) + 1);
        }
        int max = Collections.max(frequency.values());
        List<Double> modes = new ArrayList<>();
        for (var entry : frequency.entrySet()) {
            if (entry.getValue() == max) {
                modes.add(entry.getKey());
            }
        }
        return modes;
    }
    
    /**
     * Gets the median of an array
     * @param dataset the array
     * @return the median
     */
    public static double getMedian(double[] dataset) {
        double median;
        double[] copy = Arrays.copyOf(dataset, dataset.length);
        Arrays.sort(copy);
        if (copy.length % 2 == 0) {
            median = ((copy[copy.length/2-1]) + (copy[copy.length/2]))/2;
        } else {
            median = copy[copy.length/2];
        }
        return median;
    }

    /**
     * Gets the mean/average of an array
     * @param dataset the array
     * @return the mean/average
     */
    public static double getMean(double[] dataset) {
        double total = 0;
        for (double sample : dataset) {
            total += sample;
        }
        return total / dataset.length;
    }

    /**
     * Alias for getMean()
     * @param dataset the array
     * @return the average
     */
    public static double getAverage(double[] dataset) {
        return getMean(dataset);
    }

    /**
     * Maps a value from one range to another
     * 
     * For example, the number 2 in range 1-3 would become the number 5 in range 0-10
     * @param value the value to map
     * @param inMin the input range's lower limit
     * @param inMax the input range's upper limit
     * @param outMin the output range's lower limit
     * @param outMax the output range's upper limit
     * @return the mapped value
     */
    public static double map(double value,
                            double inMin, double inMax,
                            double outMin, double outMax) {
        if (inMax == inMin) {
            throw new IllegalArgumentException("Input range cannot be zero");
        }
        if (outMax == outMin) {
            throw new IllegalArgumentException("Output range cannot be zero [Auto return: 0.0]");
        }

        return lerp1d(inMin, outMin, inMax, outMax, value);
    }

    /**
     * Maps all values in an array from one range to another
     * 
     * For example, the numbers {2, 3} in range 1-3 would become the numbers {5, 10} in range 0-10
     * @param values the values to map
     * @param inMin the input range's lower limit
     * @param inMax the input range's upper limit
     * @param outMin the output range's lower limit
     * @param outMax the output range's upper limit
     * @return the mapped value
     */
    public static double[] map(double[] values, double inMin, double inMax, double outMin, double outMax) {
        double[] result = new double[values.length];
        for (int i = 0; i < values.length; i++) {
            result[i] = map(values[i], inMin, inMax, outMin, outMax);
        }
        return result;
    }
    
    /**
     * Interpolates/Extrapolates values based on 2 other known xy pairs
     * @param x0 first x, part of first xy pair
     * @param y0 first y, part of first xy pair
     * @param x1 second x, part of second xy pair
     * @param y1 second y, part of second xy pair
     * @param x third x, used to find the corresponding y-value
     * @return the third y-value
     */
    public static double lerp1d(double x0, double y0, double x1, double y1, double x) {
        if (x1 == x0) {
            throw new IllegalArgumentException("Cannot interpolate with identical x values.");
        }
        if (y1 == y0) {
            throw new IllegalArgumentException("Cannot interpolate with identical y-values [Auto returns: 0.0]");
        }
        double y = y0 + (x - x0) * (y1 - y0) / (x1 - x0);
        return y;
    }

    /**
     * Interpolates/Extrapolates an x value based on a list of coordinates
     * @param values the list of coordinates in 2d array format
     * @param x the x value to lerp
     * @return the corresponding y value
     */
    public static double lerp2d(double[][] values, double x) {
        if (values.length < 2) {
            throw new IllegalArgumentException("Need at least 2 points");
        }
        sort(values);
        // Below range → extrapolate using first segment
        if (x <= values[0][0]) {
            return lerp1d(
                    values[0][0], values[0][1],
                    values[1][0], values[1][1],
                    x
            );
        }

        // Above range → extrapolate using last segment
        if (x >= values[values.length - 1][0]) {
            int last = values.length - 1;
            return lerp1d(
                    values[last - 1][0], values[last - 1][1],
                    values[last][0], values[last][1],
                    x
            );
        }

        double x1 = 0;
        double y1 = 0;
        double x2 = 0;
        double y2 = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i][0] == x) {
                return values[i][1];
            }
            if (values[i][0] > x) {
                x1 = values[i-1][0];
                y1 = values[i-1][1];
                x2 = values[i][0];
                y2 = values[i][1];
                break;
            }
        }
        return lerp1d(x1, y1, x2, y2, x);
    }


    /**
     * Normalizes an array to be within values with no outliers
     * @param values the array
     * @param outMin the desired max value
     * @param outMax the desired min value
     * @return the normalized array
     */
    public static double[] normalize(double[] values, double outMin, double outMax) {
        double inMin = getSmallest(values);
        double inMax = getLargest(values);
        return map(values, inMin, inMax, outMin, outMax);
    }

    /**
     * Normalizes an array so that all values are between 0 and 1
     * @param values the array
     * @return the normalized array
     */
    public static double[] normalize(double[] values) {
        double inMin = getSmallest(values);
        double inMax = getLargest(values);
        return map(values, inMin, inMax, 0.0, 1.0);
    }

    /**
     * Sorts a 2D array
     * @param values the array to sort
     */
    public static void sort(double[][] values) {
        Arrays.sort(values, (a, b) -> Double.compare(a[0], b[0]));
    }

    /**
     * Gets any root (sqrt, cbrt, etc.) of any number
     * @param number number
     * @param root the root type (2nd, 3rd, 4th, etc)
     * @throws ArithmeticException trying to find the 0th root involves 
     *                             raising a number to the power of 1/0,
     *                             which is undefined.
     * @throws ArithmeticException Finding an even root of a negative number
     *                             involves imaginary numbers
     * @return the root result
     */
    public static double root(double number, double root) {
        if (root == 0) throw new ArithmeticException("/ by 0");
        if (number < 0 && root % 2 == 0) throw new ArithmeticException("Cannot work with imaginary numbers");
        if (number == 0) return 0;
        double sign = number > 0 ? 1.0 : -1.0; // Gets the sign
        number = Math.abs(number); // Removes the sign
        return sign * Math.pow(number, 1.0/root); // Calculates positive result and re-adds sign
    }

    /**
     * Performs a logarithm calculation in the form b^x = a
     * @param base the base b
     * @param answer the answer to b^x a
     * @return the missing exponent x
     */
    public static double log(double base, double answer) {
        return Math.log(answer) / Math.log(base);
    }

    public static double log10(double answer) {
        return Math.log10(answer);
    }

    public static double log2(double answer) {
        return Math.log(answer) / Math.log(2);
    }

    public static double ln(double answer) {
        return Math.log(answer);
    }

    /**
     * Checks if a number is close to another number
     * @param base the main number
     * @param comparison the number to compare to the main number
     * @param tolerance the tolerance for being "near"
     * @return boolean if the comparison is near the base
     */
    public static boolean isNear(double base, double comparison, double tolerance) {
        return Math.abs(base - comparison) <= tolerance;
    }

    public static boolean isNearPercent(double base, double comparison, double percent) {
        return Math.abs(base-comparison) <= Math.abs(comparison) * (percent / 100);
    }

    public static double round(double number, long places) {
        double scale = Math.pow(10, places);
        return Math.round(number * scale) / scale;
    }

    public static long factorial(int n) {
        if (n == 1 || n == 0) return n;
        return n * factorial(n-1);
    }

    public static double sin(double degrees) {
        return Math.sin(Math.toRadians(degrees));
    }

    public static double cos(double degrees) {
        return Math.cos(Math.toRadians(degrees));
    }

    public static double tan(double degrees) {
        return Math.tan(Math.toRadians(degrees));
    }

    public static double sin(Angle angle) {
        return Math.sin(angle.inRadians());
    }

    public static double cos(Angle angle) {
        return Math.cos(angle.inRadians());
    }

    public static double tan(Angle angle) {
        return Math.tan(angle.inRadians());
    }

    public static Angle asin(double sin) {
        return Radians.of(Math.asin(sin));
    }

    public static Angle acos(double cos) {
        return Radians.of(Math.acos(cos));
    }

    public static Angle atan(double tan) {
        return Radians.of(Math.atan(tan));
    }

   
}
