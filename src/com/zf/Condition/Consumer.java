package com.zf.Condition;

import java.util.Random;

/**
 * Created by Been on 2018/5/29.
 */
public class Consumer implements Runnable {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (buffer.isPendingLines()) {
            String line = buffer.get();
            processLine(line);
        }
    }
    /**
     * 该方法仅用于休眠10毫秒以模拟对数据行的处理
     */
    private void processLine(String line){
        try {
            Random random = new Random();
            Thread.sleep(random.nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
