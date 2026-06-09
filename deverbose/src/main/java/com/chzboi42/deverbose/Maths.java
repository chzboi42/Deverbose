package com.chzboi42.deverbose;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.chzboi42.deverbose.units.Angle;
import com.chzboi42.deverbose.units.Angle.Radians;

/**
 * Class for math-related stuff
 * @author JPSilver315
 * @since 2026 Feb 26
 * @version 0.3
 */
public final class Maths {
    private Maths() {}

    public static final BigDecimal PI = new BigDecimal("3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128481");
    public static final BigDecimal TWO_PI = PI.multiply(new BigDecimal("2"));
    public static final BigDecimal TAU = TWO_PI;
    public static final BigDecimal HALF_PI = PI.divide(new BigDecimal("2"));
    public static final BigDecimal QUARTER_PI = PI.divide(new BigDecimal("4"));

    public static final double E = 2.71828182845904523536;
    public static final double GOLDEN_RATIO = (1 + Math.sqrt(5)) / 2;

    /**
     * Checks if a number is between two numbers (included)
     * @param number the number
     * @param min the lower limit (included as part of the check)
     * @param max the upper limit (included as part of the check)
     * @return if the number is between (including) two other numbers
     */
    public static final boolean isBetween(int number, int min, int max) {
        return number >= min && number <= max;
    }

    /**
     * Gets the largest integer in an array
     * @param array the array
     * @return the largest integer in the array
     */
    public static final int getLargest(int[] array) {
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
    public static final double getLargest(double[] array) {
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
    public static final int getSmallest(int[] array) {
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
    public static final double getSmallest(double[] array) {
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
    public static final double getMode(double[] dataset) {
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
    public static final List<Double> getModes(double[] dataset) {
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
    public static final double getMedian(double[] dataset) {
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
    public static final double getMean(double[] dataset) {
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
    public static final double getAverage(double[] dataset) {
        return getMean(dataset);
    }

    /**
     * Returns a pseudorandomly chosen double value between 
     * the specified min and the specified max (both inclusive).
     * @param min
     * @param max
     * @return
     */
    public static final double random(double min, double max) {
        return map(
            (int) (Math.random()*max) + 1,
            1, max,
            min,max
        );
    }

    public static final int randInt(int min, int max) {
        return new Random().nextInt(min, max+1);
    }

    public static final double randomChoice(double... choices) {
        return choices[randInt(0,choices.length-1)];
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
    public static final double map(double value,
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
    public static final double[] map(double[] values, double inMin, double inMax, double outMin, double outMax) {
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
    public static final double lerp1d(double x0, double y0, double x1, double y1, double x) {
        if (x1 == x0) {
            throw new IllegalArgumentException("Cannot interpolate with identical x values.");
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
    public static final double lerp2d(double[][] values, double x) {
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
     * Normalizes an array so that all values are between 0 and 1
     * @param values the array
     * @return the normalized array
     */
    public static final double[] normalize(double[] values) {
        double inMin = getSmallest(values);
        double inMax = getLargest(values);
        return map(values, inMin, inMax, 0.0, 1.0);
    }

    /**
     * Sorts a 2D array
     * @param values the array to sort
     */
    public static final void sort(double[][] values) {
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
    public static final double root(double number, double root) {
        if (root == 0) throw new ArithmeticException("/ by 0");
        if (number < 0 && root % 2 == 0) throw new ArithmeticException("Cannot work with imaginary numbers");
        if (number == 0) return 0;
        double sign = number > 0 ? 1.0 : -1.0; // Gets the sign
        number = Math.abs(number); // Removes the sign
        return sign * Math.pow(number, 1.0/root); // Calculates positive result and re-adds sign
    }

    public static final double tetrate(double a, double n) {
        if (n == 1) return a;
        if (n == 0) return 0;
        return Math.pow(a,tetrate(a, n-1));
    }

    public static final double pentate(double a, double n) {
        if (n == 1) return a;
        if (n == 0) return 1;
        return tetrate(a, pentate(a, n-1));
    }

    /**
     * Performs a logarithm calculation in the form b^x = a
     * @param base the base b
     * @param answer the answer to b^x a
     * @return the missing exponent x
     */
    public static final double log(double base, double answer) {
        return Math.log(answer) / Math.log(base);
    }

    public static final double log10(double answer) {
        return Math.log10(answer);
    }

    public static final double log2(double answer) {
        return Math.log(answer) / Math.log(2);
    }

    public static final double ln(double answer) {
        return Math.log(answer);
    }

    /**
     * Checks if a number is close to another number
     * @param base the main number
     * @param comparison the number to compare to the main number
     * @param tolerance the tolerance for being "near"
     * @return boolean if the comparison is near the base
     */
    public static final boolean isNear(double base, double comparison, double tolerance) {
        return Math.abs(base - comparison) <= tolerance;
    }

    public static final boolean isWithinPercentage(double base, double comparison, double percent) {
        return Math.abs(base-comparison) <= Math.abs(comparison) * (percent / 100);
    }

    public static final double wrap(double n, double min, double max) {
        double range = max - min;
        return (n - min) % range + min + ((n - min) % range < 0 ? range : 0);
    }
    
    public static final int wrap(int n, int min, int max, boolean includeMax) {
        if (includeMax) return n > max ? n - (max+1-min) : n < min ? n + (max+1-min) : n;
        return n >= max ? n - (max-min) : n < min ? n + (max-min) : n;
    }

    public static final double round(double number, long decimalPlaces) {
        double scale = Math.pow(10, Math.clamp(decimalPlaces, 0, String.valueOf(number).length()));
        return Math.round(number * scale) / scale;
    }

    public static final BigDecimal round(BigDecimal number, int decimalPlaces) {
        return number.round(new MathContext(decimalPlaces+1));
    }

    public static final long factorial(int n) {
        if (n == 1 || n == 0) return n;
        return n * factorial(n-1);
    }

    public static final String numSysConvert(String num, int fromBase, int toBase) {
        int decimal = 0;

        for (int i = 0; i < num.length(); i++) {
            char c = Character.toLowerCase(num.charAt(i));
            int value;

            if (c >= '0' && c <= '9') {
                value = c - '0';
            } else if (c >= 'a' && c <= 'z') {
                value = c - 'a' + 10;
            } else {
                throw new NumberFormatException("Invalid character: " + c);
            }

            if (value >= fromBase) {
                throw new NumberFormatException("Invalid digit '" + c + "' for base" + fromBase);
            }

            decimal = decimal * fromBase + value;
        }

        return Integer.toString(decimal, toBase);
    }

    public static final double sin(double degrees) {
        return Math.sin(Math.toRadians(degrees));
    }

    public static final double cos(double degrees) {
        return Math.cos(Math.toRadians(degrees));
    }

    public static final double tan(double degrees) {
        return Math.tan(Math.toRadians(degrees));
    }

    public static final double sin(Angle angle) {
        return Math.sin(angle.inRadians());
    }

    public static final double cos(Angle angle) {
        return Math.cos(angle.inRadians());
    }

    public static final double tan(Angle angle) {
        return Math.tan(angle.inRadians());
    }

    public static final Angle asin(double sin) {
        return Radians.of(Math.asin(sin));
    }

    public static final Angle acos(double cos) {
        return Radians.of(Math.acos(cos));
    }

    public static final Angle atan(double tan) {
        return Radians.of(Math.atan(tan));
    }

   
}
