package com.chzboi42.deverbose.units;

public class Time {
    private final double seconds;

    private Time(double seconds) {
        this.seconds = seconds;
    }

    // --- Constructors ---

    public static class Nanoseconds {
        public static Time of(double value) {
            return new Time(value / 1_000_000_000);
        }
    }

    public static class Microseconds {
        public static Time of(double value) {
            return new Time(value / 1_000_000);
        }
    }

    public static class Milliseconds {
        public static Time of(double value) {
            return new Time(value / 1000);
        }
    }

    public static class Seconds {
        public static Time of(double value) {
            return new Time(value);
        }
    }

    public static class Minutes {
        public static Time of(double value) {
            return new Time(value * 60);
        }
    }

    public static class Hours {
        public static Time of(double value) {
            return new Time(value * 3600);
        }
    }

    public static class Days {
        public static Time of(double value) {
            return new Time(value * 86400);
        }
    }

    public static class Weeks {
        public static Time of(double value) {
            return new Time(value * 604800);
        }
    }

    // ⚠️ Approximate units

    public static class Months {
        public static Time of(double value) {
            return new Time(value * 2629746); // avg month = 30.44 days
        }
    }

    public static class Years {
        public static Time of(double value) {
            return new Time(value * 31556952); // 365.2425 days
        }
    }

    // --- Conversions ---
    
    public double inNanoSeconds() {
        return this.seconds * 1_000_000_000;
    }

    public double inMicroSeconds() {
        return this.seconds * 1_000_000;
    }

    public double inSeconds() {
        return this.seconds;
    }

    public double inMilliseconds() {
        return this.seconds * 1000;
    }

    public double inMinutes() {
        return this.seconds / 60;
    }

    public double inHours() {
        return this.seconds / 3600;
    }

    public double inDays() {
        return this.seconds / 86400;
    }

    public double inWeeks() {
        return this.seconds / 604800;
    }

    public double inMonths() {
        return this.seconds / 2629746;
    }

    public double inYears() {
        return this.seconds / 31556952;
    }

    // --- Comparisons ---

    public boolean gt(Time other) {
        return Double.compare(this.seconds, other.seconds) > 0;
    }

    public boolean gte(Time other) {
        return Double.compare(this.seconds, other.seconds) >= 0;
    }

    public boolean lt(Time other) {
        return Double.compare(this.seconds, other.seconds) < 0;
    }

    public boolean lte(Time other) {
        return Double.compare(this.seconds, other.seconds) <= 0;
    }

    public boolean isEqualTo(Time other) {
        return Double.compare(this.seconds, other.seconds) == 0;
    }

    // --- Arithmetic ---

    public Time plus(Time other) {
        return new Time(this.seconds + other.seconds);
    }

    public Time minus(Time other) {
        return new Time(this.seconds - other.seconds);
    }

    public Time times(double scalar) {
        return new Time(this.seconds * scalar);
    }

    public Time dividedBy(double scalar) {
        return new Time(this.seconds / scalar);
    }
}