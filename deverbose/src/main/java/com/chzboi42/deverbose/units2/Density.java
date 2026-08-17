package com.chzboi42.deverbose.units2;

public class Density extends AbstractRate<Mass, Volume, Density> {

    Density(double gramsPerCubicMetre) {
        super(gramsPerCubicMetre, Mass::new, Volume::new, Density::new);
    }
}
