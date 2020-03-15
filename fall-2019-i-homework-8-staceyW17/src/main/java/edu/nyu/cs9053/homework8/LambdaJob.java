package edu.nyu.cs9053.homework8;

public class LambdaJob {
    private final int startTime;
    private final int finalTime;
    public int getWeight() {
        return weight;
    }

    private final int weight;

    public int getStartTime() {
        return startTime;
    }

    public int getFinalTime() {
        return finalTime;
    }

    LambdaJob(int startTime, int finalTime)  {
        if (startTime > finalTime){
            throw new IllegalArgumentException("check interval");
        }
            this.startTime = startTime;
            this.finalTime = finalTime;
            this.weight = 0;
        }
    LambdaJob(int startTime, int finalTime, int weight){
        if (startTime > finalTime){
            throw new IllegalArgumentException("check interval");
        }
        this.startTime = startTime;
        this.finalTime = finalTime;
        this.weight = weight;
    }
}

