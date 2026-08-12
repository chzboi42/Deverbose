package com.chzboi42.deverbose.units2;

public class MassUnit extends AbstractUnit<Mass, MassUnit> {

    MassUnit(double scalar) {
        super(scalar, Mass::new, MassUnit::new);
    }

    public DensityUnit per(VolumeUnit volume) {
        return new DensityUnit(this, volume);
    }
}
