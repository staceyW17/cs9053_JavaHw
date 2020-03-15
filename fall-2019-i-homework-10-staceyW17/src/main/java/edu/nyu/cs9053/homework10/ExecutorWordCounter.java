package edu.nyu.cs9053.homework10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: blangel
 * Date: 11/16/14
 * Time: 3:33 PM
 */
public class ExecutorWordCounter extends AbstractConcurrencyFactorProvider implements WordCounter {
    private final ExecutorService executor;
    long count = 0;


    public ExecutorWordCounter(int concurrencyFactor) {
        super(concurrencyFactor);
        this.executor = Executors.newFixedThreadPool(concurrencyFactor);
    }

    @Override
    public void count(String fileContents, String word, Callback callback) {
        // TODO - implement this class using calls to an ExecutorService; one call per {@link #concurrencyFactor}
        // HINT - break up {@linkplain fileContents} and distribute the work across the calls
        // HINT - do not create the ExecutorService object in this method
        executor.submit(new Runnable() {
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
        executor.shutdownNow();
        // TODO - stop the executor
    }
}
