package com.zf.AsyncForkJoin;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created by Been on 2018/5/30.
 */
public class Main {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        FolderProcessor system = new FolderProcessor("C:\\Windows", "log");
        FolderProcessor apps = new FolderProcessor("C:\\Program", "log");
        FolderProcessor documents = new FolderProcessor("C:\\Documents And Settings", "log");
        pool.execute(system);
        pool.execute(apps);
        pool.execute(documents);
        do {
            System.out.printf("*******************");
            System.out.printf("Main:Active Threads:%d\n", pool.getActiveThreadCount());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while ((!system.isDone()) || (!apps.isDone()) || (!documents.isDone()));
        pool.shutdown();
        List<String> results;
        results = system.join();
        System.out.printf("System:%d files found.\n", results.size());
        results = apps.join();
        System.out.printf("Apps:%d files found.\n", results.size());
        results = documents.join();
        System.out.printf("Documents:%d files found.\n", results.size());
    }
}
