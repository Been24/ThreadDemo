package com.zf.Produce;

/**
 * Created by Been on 2018/5/29.
 */
public class Consumer implements Runnable {
    private  EventStorage storage;

    public Consumer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i=0;i<100;i++) {
            storage.get();
        }
    }
}
