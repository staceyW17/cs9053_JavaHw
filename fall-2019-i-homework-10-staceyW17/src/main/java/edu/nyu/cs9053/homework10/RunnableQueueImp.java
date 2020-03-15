package edu.nyu.cs9053.homework10;
import java.util.concurrent.BlockingQueue;

public class RunnableQueueImp extends Thread {

    private final BlockingQueue<Runnable> taskList;

    public RunnableQueueImp(BlockingQueue<Runnable> taskList) {
        this.taskList = taskList;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Runnable task = this.taskList.take();
                task.run();
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public void finishTask() {
        this.interrupt();
    }
}