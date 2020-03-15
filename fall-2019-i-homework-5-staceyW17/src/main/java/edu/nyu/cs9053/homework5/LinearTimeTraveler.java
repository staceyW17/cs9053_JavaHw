package edu.nyu.cs9053.homework5;

public class LinearTimeTraveler extends AbstractTimeTraveler{
    public LinearTimeTraveler(String name, Double remainingYearsOfTravel){
        super(name,remainingYearsOfTravel);
    }

    @Override
    public void adjust(Time unit, int amount, boolean ahead){
        switch (unit){
            case Days:
                this.remainingYearsOfTravel -= (double)(amount)/constant;
                break;
            case Hours:
                this.remainingYearsOfTravel -= (double)(amount)/365d;
                break;
            default:
                throw new AssertionError();
        }
    }
}