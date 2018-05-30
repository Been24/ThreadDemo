package com.zf.Lock;

/**
 * Created by Been on 2018/5/29.
 */
public class Main {
    public static void main(String[] args) {
        PrintQueue queue = new PrintQueue();
        Thread thread[] = new Thread[10];
        for(int i=0;i<10;i++) {
            thread[i] = new Thread(new Job(queue), "Thread"+i);
        }
        for (int i=0;i<10;i++) {
            thread[i].start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
