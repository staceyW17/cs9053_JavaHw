package edu.nyu.cs9053.homework10;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * User: blangel
 * Date: 11/16/14
 * Time: 3:16 PM
 */
public class ThreadedWordCounter extends AbstractConcurrencyFactorProvider implements WordCounter {
    //    private final Lock lock;
    private static final boolean INITIAL_ISSTART = false;
    private final ThreadPoolImp threadPool;
    private final AtomicBoolean isStart;
    long count = 0;


    public ThreadedWordCounter(int concurrencyFactor) {
        super(concurrencyFactor);
        this.threadPool = new ThreadPoolImp(concurrencyFactor);
        this.isStart = new AtomicBoolean(INITIAL_ISSTART);

    }

    @Override
    public void count(String fileContents, String word, Callback callback) {
        // TODO - implement this class using Thread objects; one Thread per {@link #concurrencyFactor}
        // HINT - break up {@linkplain fileContents} and distribute the work across the threads
        // HINT - do not create the Thread objects in this method
        if (this.isStart.get() == false) {
            this.threadPool.startThreads();
            this.isStart.set(true);
        }
        this.threadPool.addTask(new Runnable() {
            @Override
            public void run() {
                try {
                    String[] content = fileContents.split(" ");
                    for (int i = 1; i < content.length; i++) {
                        if (content[i].equalsIgnoreCase(word)) {
                            count++;
                            callback.counted(count);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void stop() {
        // TODO - stop the threads
        this.threadPool.endTask();
    }

}