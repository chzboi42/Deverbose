package com.chzboi42.deverbose.units;

public class Pressure {
    private double pascals;

    private Pressure(double pascals) {
        this.pascals = pascals;
    }

    public static class Pascals {
        public static Pressure of(double pascals) {
            return new Pressure(pascals);
        }
    }

    public static class Bars {
        public static Pressure of(double bars) {
            return new Pressure(bars*100000);
        }
    }

    public static class PSI {
        public static Pressure of(double PSI) {
            return new Pressure(PSI*6894.76);
        }
    }

    public static class StandardAtmospheres {
        public static Pressure of(double atm) {
            return new Pressure(atm*101325);
        }
    }

    public static class Torrs {
        public static Pressure of(double torr) {
            return new Pressure(torr*133.322);
        }
    }

    public double inPascals() {
        return this.pascals;
    }

    public double inBars() {
        return this.pascals / 100000;
    }

    public double inPSI() {
        return this.pascals / 6894.76;
    }

    public double inAtm() {
        return this.pascals / 101325;
    }

    public double inTorrs() {
        return this.pascals / 133.322;
    }

}