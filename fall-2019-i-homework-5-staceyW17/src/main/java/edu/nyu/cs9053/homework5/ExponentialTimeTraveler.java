package edu.nyu.cs9053.homework5;

public class ExponentialTimeTraveler extends AbstractTimeTraveler{

    private int exponentialDecayConstant;
    public ExponentialTimeTraveler(String name, Double remainingYearsOfTravel, int exponentialDecayConstant){
        super(name,remainingYearsOfTravel);
        this.exponentialDecayConstant = exponentialDecayConstant;
    }

    @Override
    public void adjust(Time unit, int amount, boolean ahead) {
        switch (unit) {
            case Days:
                this.remainingYearsOfTravel -= Math.exp(this.exponentialDecayConstant) * (double) (amount) / constant;
                break;
            case Hours:
                this.remainingYearsOfTravel -= Math.exp(this.exponentialDecayConstant) * (double) (amount) / 365d;
                break;
            default:
                throw new AssertionError();
        }
    }
}
