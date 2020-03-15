package edu.nyu.cs9053.homework10;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * User: blangel
 * Date: 11/16/14
 * Time: 3:50 PM
 */
public class ThreadedFilesWordCounter extends AbstractConcurrencyFactorProvider implements FilesWordCounter {
    private final WordCounter wordCounter;

    public ThreadedFilesWordCounter(int concurrencyFactor) {
        super(concurrencyFactor);
        this.wordCounter = new ThreadedWordCounter(getConcurrencyFactor());
    }

    @Override
    public void count(Map<String, String> files, String word, Callback callback) {
        // TODO - implement this class using Thread objects; one Thread per {@link #concurrencyFactor} with each Thread handling at most one file at one time
        // HINT - do not create the ExecutorService object in this method
        Iterator<Map.Entry<String, String>> entries = files.entrySet().iterator();
        while (entries.hasNext()) {
            String filecontents = entries.next().getValue();
            wordCounter.count(filecontents, word, new WordCounter.Callback() {
                @Override
                public void counted(long count) {
                    System.out.printf("Word %s appears %d times within %s%n", word, count, entries.next().getKey());
                }
            });
        }

    }

    @Override
    public void stop() {
        // TODO - stop the threads
        Thread.currentThread().interrupt();
    }
}
