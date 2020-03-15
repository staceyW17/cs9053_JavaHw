package edu.nyu.cs9053.homework8;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaScheduler {
    private final List<LambdaJob> jobs;

    public LambdaScheduler(List<LambdaJob> jobs) {
        this.jobs = jobs;
    }

    public int schedule(){
        if (jobs.size()== 0){
            return 0;
        }
        Collections.sort(jobs, new Comparator<LambdaJob>() {
            @Override
            public int compare(LambdaJob a, LambdaJob b){
                return a.getFinalTime()-b.getFinalTime();
            }
        });
        int count = 1;
        int thePreviousEnd = jobs.get(1).getFinalTime();
        for(LambdaJob job : jobs){
            if(job.getStartTime() >= thePreviousEnd){
                count++;
                thePreviousEnd = job.getFinalTime();
            }
        }
        return count;
    }
}
