package edu.nyu.cs9053.homework10;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: blangel
 * Date: 11/16/14
 * Time: 3:50 PM
 */
public class ExecutorFilesWordCounter extends AbstractConcurrencyFactorProvider implements FilesWordCounter {
    private final ExecutorService executor;
    private final ExecutorWordCounter wordCounter;




    public ExecutorFilesWordCounter(int concurrencyFactor) {
        super(concurrencyFactor);
        this.executor = Executors.newFixedThreadPool(concurrencyFactor);
        this.wordCounter = new ExecutorWordCounter(getConcurrencyFactor());
    }


    @Override public void count(Map<String, String> files, String word, Callback callback) {
        // TODO - implement this class using calls to an ExecutorService; with one call per {@linkplain concurrencyFactor}.
        // HINT - do not create the ExecutorService object in this method
        Iterator<Map.Entry<String, String>> entries = files.entrySet().iterator();

        while (entries.hasNext()) {
              String filecontents = entries.next().getValue();
            this.wordCounter.count(filecontents,word, new WordCounter.Callback(){

                @Override
                public void counted(long count) {
                    System.out.printf("Word %s appears %d times within %s%n", word, count, entries.next().getKey());
                }
            });


        }

    }

    @Override public void stop() {
        // TODO - stop the executor
        executor.shutdownNow();
    }

}
