package edu.nyu.cs9053.homework9;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * User: blangel
 */
public class Factory {
    private static final Semaphore BINARY_SEMAPHORE = new Semaphore(1);

    public static final Voter createVoter() {
        Random random = new Random();
        int pick = random.nextInt(2);
        Ballot[] ballots = {new BigBang(), new Got7(), new Winner()};
        return new VoterImplementation(ballots[pick], BINARY_SEMAPHORE);
    }

    public static VoteCounter createVoteCounter() {
        return new VoteCounterImplementation(BINARY_SEMAPHORE);
    }
}
