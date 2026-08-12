package com.chzboi42.deverbose.units2;

public class DensityUnit extends RateUnit<Mass, Volume> {

    DensityUnit(MassUnit mass, VolumeUnit volume) {
        super(mass, volume, Mass::new, Volume::new);
    }

    @Override
    public Density of(double value) {
        return new Density(convertToBase(value));
    }

    @Override
    protected DensityUnit withScalar(double scalar) {
        // Create an updated DistanceUnit with the scaled ratio
        return new DensityUnit((MassUnit) getNumeratorUnit().withScalar(scalar * getDenominatorUnit().convertToBase(1.0)), (VolumeUnit) getDenominatorUnit());
    }
}
