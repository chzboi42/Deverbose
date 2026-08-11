package com.chzboi42.deverbose.units2;

import static com.chzboi42.deverbose.units2.Units.CubicMetres;
import static com.chzboi42.deverbose.units2.Units.Metres;
import static com.chzboi42.deverbose.units2.Units.SquareMetres;

public class Volume extends AbstractMeasure<Volume, VolumeUnit> {

    Volume(double litres) {
        super(litres, Volume::new);
    }

    public Area dividedBy(Distance other) {
        return new Area(this.in(CubicMetres)/ other.in(Metres));
    }

    public Distance dividedBy(Area other) {
        return new Distance(this.in(CubicMetres)/ other.in(SquareMetres));
    }
}
