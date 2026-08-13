package com.chzboi42.deverbose.units2;

import java.util.Objects;

public final class Units {

    private Units() {
        throw new IllegalStateException("This is a utility class!");
    }

    public static final AngleUnit Radians   = new AngleUnit(1);
    public static final AngleUnit Degrees   = new AngleUnit(Math.toRadians(1));
    public static final AngleUnit Gradians  = new AngleUnit(Math.toRadians(0.9));
    public static final AngleUnit Rotations = new AngleUnit(Math.TAU);

    public static final DistanceUnit Metres       = new DistanceUnit(1);
    public static final DistanceUnit Picometres   = milli(nano(Metres));
    public static final DistanceUnit Nanometres   = nano(Metres);
    public static final DistanceUnit Micrometres  = micro(Metres);
    public static final DistanceUnit Millimetres  = milli(Metres);
    public static final DistanceUnit Centimetres  = centi(Metres);
    public static final DistanceUnit Decimetres   = deci(Metres);
    public static final DistanceUnit Meters       = Metres;
    public static final DistanceUnit Decametres   = deca(Metres);
    public static final DistanceUnit Dekametres   = Decametres;
    public static final DistanceUnit Hectometres  = hecto(Metres);
    public static final DistanceUnit Kilometres   = kilo(Metres);
    public static final DistanceUnit Inches       = new DistanceUnit(0.0254);
    public static final DistanceUnit Feet         = new DistanceUnit(0.3048);
    public static final DistanceUnit Yards        = new DistanceUnit(0.9144);
    public static final DistanceUnit Furlongs     = new DistanceUnit(1609.344 / 8);
    public static final DistanceUnit Miles        = new DistanceUnit(1609.344);
    public static final DistanceUnit NauticalMiles = new DistanceUnit(1852);
    public static final DistanceUnit LightYears    = new DistanceUnit(9.461e+15);

    public static final TimeUnit Seconds      = new TimeUnit(1);
    public static final TimeUnit Nanoseconds  = new TimeUnit(0.000000001);
    public static final TimeUnit Microseconds = new TimeUnit(0.000001);
    public static final TimeUnit Milliseconds = new TimeUnit(0.001);
    public static final TimeUnit Minutes      = new TimeUnit(60);
    public static final TimeUnit Hours        = new TimeUnit(3600);
    public static final TimeUnit Days         = new TimeUnit(86400);

    public static final TemperatureUnit Kelvin     = new TemperatureUnit(1);
    public static final TemperatureUnit Celsius    = new TemperatureUnit(c -> c + 273.15, k -> k - 273.15);
    public static final TemperatureUnit Fahrenheit = new TemperatureUnit(f -> (f - 32) / 1.8 + 273.15, k -> (k - 273.15) * 1.8 + 32);

    public static final ForceUnit Newtons     = new ForceUnit(1);
    public static final ForceUnit Dynes       = new ForceUnit(1.0 / 100_000);
    public static final ForceUnit PoundForces = new ForceUnit(4.44822);
    public static final ForceUnit Poundals    = new ForceUnit(0.13825);
    public static final ForceUnit Kiloponds   = new ForceUnit(9.80665);

    public static final MassUnit Grams      = new MassUnit(1.0);
    public static final MassUnit Milligrams = milli(Grams);
    public static final MassUnit Centigrams = centi(Grams);
    public static final MassUnit Decigrams  = deci(Grams);
    public static final MassUnit Kilograms  = kilo(Grams);
    public static final MassUnit Tonnes     = new MassUnit(1_000_000.0);
    public static final MassUnit Ounces     = new MassUnit(28.349523125);
    public static final MassUnit Pounds     = new MassUnit(453.59237);
    public static final MassUnit Stones     = new MassUnit(6350.29318);
    public static final MassUnit ShortTons  = new MassUnit(907_184.74);
    public static final MassUnit LongTons   = new MassUnit(1_016_046.9088);

    public static final PressureUnit Pascals             = new PressureUnit(1.0);
    public static final PressureUnit Bars                = new PressureUnit(100_000.0);
    public static final PressureUnit Psi                 = new PressureUnit(6894.76);
    public static final PressureUnit StandardAtmospheres = new PressureUnit(101_325.0);
    public static final PressureUnit Torrs               = new PressureUnit(133.322);

    public static final AreaUnit SquareMetres      = new AreaUnit(1.0);
    public static final AreaUnit SquareMillimetres = new AreaUnit(1.0 / 1_000_000.0);
    public static final AreaUnit SquareCentimetres = new AreaUnit(1.0 / 10_000.0);
    public static final AreaUnit SquareDecimetres  = new AreaUnit(1.0 / 100.0);
    public static final AreaUnit SquareKilometres = new AreaUnit(1_000_000.0);
    public static final AreaUnit Hectares         = new AreaUnit(10_000.0);
    public static final AreaUnit SquareInches     = new AreaUnit(0.00064516);
    public static final AreaUnit SquareFeet       = new AreaUnit(0.09290304);
    public static final AreaUnit SquareYards      = new AreaUnit(0.83612736);
    public static final AreaUnit SquareMiles      = new AreaUnit(2_589_988.110336);
    public static final AreaUnit Acres            = new AreaUnit(4046.8564224);

    public static final VolumeUnit Litres            = new VolumeUnit(1.0);
    public static final VolumeUnit Millilitres       = milli(Litres);
    public static final VolumeUnit Centilitres       = centi(Litres);
    public static final VolumeUnit Decilitres        = deci(Litres);
    public static final VolumeUnit CubicMetres       = new VolumeUnit(1000.0);
    public static final VolumeUnit UsTeaspoons       = new VolumeUnit(0.00492892159); 
    public static final VolumeUnit UsTablespoons     = new VolumeUnit(0.0147867648); 
    public static final VolumeUnit UsFluidOunces     = new VolumeUnit(0.0295735295625);
    public static final VolumeUnit UsCups            = new VolumeUnit(0.2365882365);
    public static final VolumeUnit UsPints           = new VolumeUnit(0.473176473);
    public static final VolumeUnit UsQuarts          = new VolumeUnit(0.946352946);
    public static final VolumeUnit UsGallons         = new VolumeUnit(3.785411784);
    public static final VolumeUnit UkTeaspoons       = new VolumeUnit(0.00591938802);
    public static final VolumeUnit UkTablespoons     = new VolumeUnit(0.0177581641);
    public static final VolumeUnit UkFluidOunces     = new VolumeUnit(0.0284130625);
    public static final VolumeUnit UkPints           = new VolumeUnit(0.56826125);
    public static final VolumeUnit UkQuarts          = new VolumeUnit(1.1365225);
    public static final VolumeUnit UkGallons         = new VolumeUnit(4.54609);
    public static final VolumeUnit CubicCentimetres = Millilitres;
    public static final VolumeUnit CubicInches      = new VolumeUnit(0.016387064);  
    public static final VolumeUnit CubicFeet        = new VolumeUnit(28.316846592); 

    public static final LinearVelocityUnit MPS = Metres.per(Seconds); 
    public static final LinearVelocityUnit KPH = Kilometres.per(Hours);
    public static final LinearVelocityUnit MPH = Miles.per(Hours);
    public static final LinearVelocityUnit Knots = NauticalMiles.per(Hours);
    public static final LinearVelocityUnit Mach = MPS.scale(343);

    public static final AngularVelocityUnit RadPerSec = Radians.per(Seconds);
    public static final AngularVelocityUnit RPM  = Rotations.per(Minutes);
    public static final AngularVelocityUnit RPS  = Rotations.per(Seconds);
    public static final AngularVelocityUnit DGPS = Degrees.per(Seconds); 

    public static final DensityUnit GramsPerLitre       = Grams.per(Litres);
    public static final DensityUnit GramsPerCubicCentimetre = Grams.per(CubicCentimetres);
    public static final DensityUnit GramsPerMillilitre       = Grams.per(Millilitres);
    public static final DensityUnit KilogramsPerCubicMetre  = Kilograms.per(CubicMetres);
    public static final DensityUnit KilogramsPerLitre       = Kilograms.per(Litres);
    public static final DensityUnit PoundsPerCubicFoot      = Pounds.per(CubicFeet);
    public static final DensityUnit PoundsPerCubicInch      = Pounds.per(CubicInches);
    public static final DensityUnit PoundsPerUsGallon       = Pounds.per(UsGallons);

    
    public static <U extends AbstractUnit<Q, U>, Q extends AbstractMeasure<Q, U>> U nano(U unit) {
        if (unit instanceof TemperatureUnit && unit != Kelvin) {
            throw new IllegalArgumentException("Cannot apply metric prefixes to offset temperature units like Celsius or Fahrenheit!");
        }
        return (U) Objects.requireNonNull(unit).scale(0.000000001);
    }

    public static <U extends AbstractUnit<Q, U>, Q extends AbstractMeasure<Q, U>> U micro(U unit) {
        if (unit instanceof TemperatureUnit && unit != Kelvin) {
            throw new IllegalArgumentException("Cannot apply metric prefixes to offset temperature units like Celsius or Fahrenheit!");
        }
        return (U) Objects.requireNonNull(unit).scale(0.000001);
    }
    
    public static <U extends AbstractUnit<Q, U>, Q extends AbstractMeasure<Q, U>> U milli(U unit) {
        if (unit instanceof TemperatureUnit && unit != Kelvin) {
            throw new IllegalArgumentException("Cannot apply metric prefixes to offset temperature units like Celsius or Fahrenheit!");
        }
        return (U) Objects.requireNonNull(unit).scale(0.001);
    }

    public static <U extends AbstractUnit<Q, U>, Q extends AbstractMeasure<Q, U>> U centi(U unit) {
        if (unit instanceof TemperatureUnit && unit != Kelvin) {
            throw new IllegalArgumentException("Cannot apply metric prefixes to offset temperature units like Celsius or Fahrenheit!");
        }
        return (U) Objects.requireNonNull(unit).scale(0.01);
    }

    public static <U extends AbstractUnit<Q, U>, Q extends AbstractMeasure<Q, U>> U deci(U unit) {
        if (unit instanceof TemperatureUnit && unit != Kelvin) {
            throw new IllegalArgumentException("Cannot apply metric prefixes to offset temperature units like Celsius or Fahrenheit!");
        }
        return (U) Objects.requireNonNull(unit).scale(0.1);
    }

    public static <U extends AbstractUnit<Q, U>, Q extends AbstractMeasure<Q, U>> U deca(U unit) {
        if (unit instanceof TemperatureUnit && unit != Kelvin) {
            throw new IllegalArgumentException("Cannot apply metric prefixes to offset temperature units like Celsius or Fahrenheit!");
        }
        return (U) Objects.requireNonNull(unit).scale(10.0);
    }

    public static <U extends AbstractUnit<Q, U>, Q extends AbstractMeasure<Q, U>> U hecto(U unit) {
        if (unit instanceof TemperatureUnit && unit != Kelvin) {
            throw new IllegalArgumentException("Cannot apply metric prefixes to offset temperature units like Celsius or Fahrenheit!");
        }
        return (U) Objects.requireNonNull(unit).scale(100.0);
    }

    public static <U extends AbstractUnit<Q, U>, Q extends AbstractMeasure<Q, U>> U kilo(U unit) {
        if (unit instanceof TemperatureUnit && unit != Kelvin) {
            throw new IllegalArgumentException("Cannot apply metric prefixes to offset temperature units like Celsius or Fahrenheit!");
        }
        return (U) Objects.requireNonNull(unit).scale(1000.0);
    }
}