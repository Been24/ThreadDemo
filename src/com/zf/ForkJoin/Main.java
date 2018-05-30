package com.zf.ForkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created by Been on 2018/5/30.
 */
public class Main {
    public static void main(String[] args) {
        DocumentMock mock = new DocumentMock();
        String[][] document = mock.generateDocument(100, 1000, "the");
        DocumentTask task = new DocumentTask(document, 0, 100, "the");
        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(task);
        do {
            System.out.printf("**************************************\n");
            System.out.printf("Main:Active Threads:%d\n", pool.getActiveThreadCount());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!task.isDone());
        pool.shutdown();
        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.printf("Main:The word appears %d in the document", task.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
