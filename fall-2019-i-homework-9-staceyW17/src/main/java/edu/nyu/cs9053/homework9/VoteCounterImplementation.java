package edu.nyu.cs9053.homework9;

import java.util.concurrent.Semaphore;

public final class VoteCounterImplementation implements VoteCounter {
    private final Semaphore semaphore;

    protected VoteCounterImplementation(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public QueueNumber count(Queue from) {
        try{
            semaphore.acquire();
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        try {
            if(!from.isEmpty()) {
                return from.getQueueNumber();
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
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        VoteCounterImplementation that = (VoteCounterImplementation) o;

        return semaphore == null ? that.semaphore == null : semaphore.equals(that.semaphore);
    }

    @Override
    public int hashCode() {
        return semaphore == null ? 0 : semaphore.hashCode();
    }
}