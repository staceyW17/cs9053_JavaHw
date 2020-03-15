package edu.nyu.cs9053.homework8;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaWeightedScheduler {
    private final List<LambdaJob> jobs;

    public LambdaWeightedScheduler(List<LambdaJob> jobs) {
        this.jobs = jobs;
    }

    public int schedule(){
        int[] weights = new int[jobs.size()+1];
        Collections.sort(jobs, new Comparator<LambdaJob>() {
            @Override
            public int compare(LambdaJob a, LambdaJob b){
                return a.getFinalTime()-b.getFinalTime();
            }
        });
        int size = jobs.size();
        jobs.add(new LambdaJob(Integer.MAX_VALUE,Integer.MAX_VALUE));
        for (int i = size; i >= 0;i--) {
            for (int j = i+1; j <= size; j++) {
                if (jobs.get(j).getStartTime() >= jobs.get(i).getFinalTime()) {
                    int temp = Math.max(weights[i + 1], weights[j] + jobs.get(i).getWeight());
                    weights[i] = Math.max(temp,weights[i]);
                }
            }
        }
        jobs.remove(size);
        return weights[0];
    }
}


