package homework.patternExamples.creational;

public class BuilderExample {
    public static void main(String[] args) {
        Director director = new Director();
        director.setCarrBuilder(new FordMondeoBuilder());
        Carr carr = director.buildCarr();
        System.out.println(carr);
    }
}

enum Transmission {
    MANUAL,
    AUTO
}

class Carr {
    private String make;
    private Transmission transmission;
    private int maxSpeed;

    void setMake(String make) {
        this.make = make;
    }

    void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Carr{" +
                "make='" + make + '\'' +
                ", transmission=" + transmission +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}

abstract class CarrBuilder {
    Carr carr;

    void createCarr() {
        carr = new Carr();
    }

    abstract void buildMake();

    abstract void buildTransmission();

    abstract void buildMaxSpeed();

    Carr getCarr() {
        return carr;
    }
}

class FordMondeoBuilder extends CarrBuilder {

    @Override
    void buildMake() {
        carr.setMake("Ford Mondeo");
    }

    @Override
    void buildTransmission() {
        carr.setTransmission(Transmission.AUTO);
    }

    @Override
    void buildMaxSpeed() {
        carr.setMaxSpeed(220);
    }
}

class SubaruBuilder extends CarrBuilder {

    @Override
    void buildMake() {
        carr.setMake("Subaru");
    }

    @Override
    void buildTransmission() {
        carr.setTransmission(Transmission.MANUAL);
    }

    @Override
    void buildMaxSpeed() {
        carr.setMaxSpeed(320);
    }
}

class Director {
    private CarrBuilder builder;

    void setCarrBuilder(CarrBuilder b) {
        this.builder = b;
    }

    Carr buildCarr() {
        builder.createCarr();
        builder.buildMake();
        builder.buildMaxSpeed();
        builder.buildTransmission();
        Carr carr = builder.getCarr();
        return carr;
    }
}
