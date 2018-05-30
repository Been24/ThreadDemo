package com.zf.Condition;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 数据缓冲类Buffer,被共享
 * Created by Been on 2018/5/29.
 */
public class Buffer {
    //用来存放共享数据
    private LinkedList<String> buffer;
    //buffer长度
    private int maxSize;
    //
    private ReentrantLock lock;
    //Condition属性
    private Condition lines;
    private Condition space;
    //用来表明缓冲区是否还有数据
    private boolean pendingLines;

    public Buffer(int maxSize) {
        this.maxSize=maxSize;
        buffer = new LinkedList<>();
        lock = new ReentrantLock();
        lines = lock.newCondition();
        space = lock.newCondition();
        pendingLines = true;
    }

    public void insert(String line) {
        lock.lock();
        try {
            while (buffer.size() == maxSize) {
                space.await();
            }
            buffer.offer(line);
            System.out.printf("%s:Inserted Line:%d\n", Thread.currentThread().getName(), buffer.size());
            lines.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public String get(){
        String line=null;
        lock.lock();
        try {
            while ((buffer.size() == 0) && (isPendingLines())) {
                lines.await();
            }
            if (isPendingLines()) {
                line = buffer.poll();
                System.out.printf("%s:Line Readed:%d\n", Thread.currentThread().getName(), buffer.size());
                space.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return line;
    }

    public boolean isPendingLines() {
        return pendingLines||buffer.size()>0;
    }

    public void setPendingLines(boolean pendingLines) {
        this.pendingLines = pendingLines;
    }
}
