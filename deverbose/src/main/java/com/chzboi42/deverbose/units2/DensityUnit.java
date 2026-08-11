package com.chzboi42.deverbose.units2;

public class DensityUnit extends RateUnit<Mass, Volume> {

    DensityUnit(MassUnit mass, VolumeUnit volume) {
        super(mass, volume, Mass::new, Volume::new);
    }

    @Override
    public Density of(double value) {
        return new Density(convertToBase(value));
    }
}
