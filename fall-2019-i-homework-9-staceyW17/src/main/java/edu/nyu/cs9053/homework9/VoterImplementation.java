package edu.nyu.cs9053.homework9;

import java.util.concurrent.Semaphore;

public final class VoterImplementation implements Voter {
    private final Semaphore semaphore;
    private final Ballot ballot;

    protected VoterImplementation(Ballot ballot, Semaphore semaphore) {
        this.ballot = ballot;
        this.semaphore = semaphore;
    }

    @Override
    public QueueNumber vote(Queue queue) {
        try {
            semaphore.acquire();
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(ie);
        }
        try {
            if (!queue.full()) {
                return queue.addBallot(this.ballot);
            }
        } finally {
            this.semaphore.release();
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        VoterImplementation that = (VoterImplementation) o;
        return semaphore == null ? that.semaphore == null : semaphore.equals(that.semaphore)
                && ballot == null ? that.ballot == null : ballot.equals(that.ballot);
    }

    @Override
    public int hashCode() {
        int result = (semaphore == null ? 0 : semaphore.hashCode());
        return 31 * result + (ballot == null ? 0 : ballot.hashCode());
    }
}
