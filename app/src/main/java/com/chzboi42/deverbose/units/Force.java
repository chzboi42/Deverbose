package com.chzboi42.deverbose.units;

/** Same as Weight */
public class Force {
    private final double newtons;

    private Force(double newtons) {
        this.newtons = newtons;
    }

    public class Newtons {
        public static Force of(double newtons) {
            return new Force(newtons);
        }
    }

    public class Dynes {
        public static Force of(double dynes) {
            return new Force(dynes/100000);
        }
    }

    public class PoundForces {
        public static Force of(double poundforces) {
            return new Force(poundforces*4.44822);
        }
    }

    public class Poundals {
        public static Force of(double poundals) {
            return new Force(poundals*0.13825);
        }
    }

    public class Kiloponds {
        public static Force of(double kiloponds) {
            return new Force(kiloponds*9.80665);
        }
    }

    public double inNewtons() {
        return this.newtons;
    }

    public double inDynes() {
        return this.newtons*100000;
    }

    public double inPoundForces() {
        return this.newtons / 4.44822;
    }

    public double inPoundals() {
        return this.newtons / 0.13825;
    }

    public double inKiloponds() {
        return this.newtons / 9.80665;
    }

    public boolean gt(Force comparison) {
        return Double.compare(this.newtons, comparison.newtons) > 0;
    }

    public boolean gte(Force comparison) {
        return Double.compare(this.newtons, comparison.newtons) >= 0;
    }

    public boolean lt(Force comparison) {
        return Double.compare(this.newtons, comparison.newtons) < 0;
    }

    public boolean lte(Force comparison) {
        return Double.compare(this.newtons, comparison.newtons) <= 0;
    }

    public boolean isEqualTo(Force comparison) {
        return Double.compare(this.newtons, comparison.newtons) == 0;
    }

    public Force plus(Force other) {
        return new Force(this.newtons + other.newtons);
    }

    public Force minus(Force other) {
        return new Force(this.newtons - other.newtons);
    }

    public Force times(double scalar) {
        return new Force(this.newtons * scalar);
    }

    public Force dividedBy(double scalar) {
        return new Force(this.newtons / scalar);
    }

}