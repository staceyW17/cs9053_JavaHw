package edu.nyu.cs9053.homework9;

import java.util.Random;

public abstract class BoyBandBallot implements Ballot{
    private final Random random = new Random();
    private boolean isYes = false;

    @Override
    public boolean isYes() {
        isYes = random.nextBoolean();
        return isYes;
    }
}
