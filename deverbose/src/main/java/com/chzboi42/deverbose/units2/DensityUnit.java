package com.chzboi42.deverbose.units2;

public class DensityUnit extends AbstractRateUnit<Mass, Volume, Density> {

    DensityUnit(MassUnit mass, VolumeUnit volume) {
        super(mass, volume, Density::new);
    }

    @Override
    public Density of(double value) {
        return new Density(convertToBase(value));
    }

    @Override
    public DensityUnit scale(double scalar) {
        return new DensityUnit((MassUnit) getNumeratorUnit().scale(scalar), (VolumeUnit) getDenominatorUnit());
    }
}   
