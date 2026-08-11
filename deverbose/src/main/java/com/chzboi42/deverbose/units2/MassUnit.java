package com.chzboi42.deverbose.units2;

public class MassUnit extends AbstractUnit<Mass> {

    MassUnit(double scalar) {
        super(scalar, Mass::new);
    }

    public DensityUnit per(VolumeUnit volume) {
        return new DensityUnit(this, volume);
    }
}
