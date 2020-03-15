package edu.nyu.cs9053.homework5;

public class DoubleTimeTraveler extends AbstractTimeTraveler{
    public DoubleTimeTraveler(String name, Double remainingYearsOfTravel){
        super(name,remainingYearsOfTravel);
    }


    @Override
    public void adjust(Time unit, int amount, boolean ahead){
        switch (unit){
            case Days:
                this.remainingYearsOfTravel -= 2 * (double)(amount)/constant;
                break;
            case Hours:
                this.remainingYearsOfTravel -= 2 * (double)(amount)/365d;
                break;
            default:
                throw new AssertionError();

        }
    }
}
