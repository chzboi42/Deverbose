package com.chzboi42.deverbose.units2;

public class VolumeUnit extends AbstractUnit<Volume> {

    VolumeUnit(double scalar) {
        super(scalar, Volume::new);
    }

    @Override
    protected VolumeUnit withScalar(double scalar) {
        return new VolumeUnit(scalar);
    }
}
