package edu.nyu.cs9053.homework5;

public abstract class AbstractTimeTraveler implements TimeTraveler {
    protected final String name;
    protected Double remainingYearsOfTravel;
    protected static final double constant =  24d * 365d;

    public AbstractTimeTraveler(String name, Double remainingYearsOfTravel) {
        this.name = name;
        this.remainingYearsOfTravel = remainingYearsOfTravel;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getRemainingYearsOfTravel() {
        return remainingYearsOfTravel;
    }

}
