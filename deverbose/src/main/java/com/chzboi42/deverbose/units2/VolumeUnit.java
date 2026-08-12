package com.chzboi42.deverbose.units2;

public class VolumeUnit extends AbstractUnit<Volume, VolumeUnit> {

    VolumeUnit(double scalar) {
        super(scalar, Volume::new, VolumeUnit::new);
    }
}
