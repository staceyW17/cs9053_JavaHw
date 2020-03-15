package edu.nyu.cs9053.homework10;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

public class ThreadPoolImp {

    private static final int TASK_SIZE = 20;

    private final int concurrencyFactor;

    private final List<RunnableQueueImp> threads;

    private final BlockingQueue<Runnable> taskList;
    CountDownLatch countDownLatch;

    public ThreadPoolImp(int concurrencyFactor) {
        this.concurrencyFactor = concurrencyFactor;
        this.threads = new ArrayList<RunnableQueueImp>(concurrencyFactor);

        // taskSize should be length of files
        this.taskList = new ArrayBlockingQueue<Runnable>(TASK_SIZE);
        this.countDownLatch = new CountDownLatch(concurrencyFactor);

    }

    public void startThreads() {
        for (int i = 0; i < this.concurrencyFactor; i++) {
            this.threads.add(new RunnableQueueImp(taskList));
            this.threads.get(i).start();
            countDownLatch.countDown();
        }
        try {
            countDownLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //print result
    }

    public void addTask(Runnable task) {
        try {
            taskList.put(task);
            taskList.notifyAll();
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(ie);
        }
    }

    public void endTask() {
        for (RunnableQueueImp thread : this.threads) {
            thread.finishTask();
        }
    }
}