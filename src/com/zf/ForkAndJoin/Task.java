package com.zf.ForkAndJoin;

import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * Created by Been on 2018/5/30.
 */
public class Task extends RecursiveAction {
    private static final long serialVersionUID=1L;
    private List<Product> products;
    private  int first;
    private  int last;
    //价格增加额
    private double increment;

    public Task(List<Product> products, int first, int last, double increment) {
        this.products = products;
        this.first = first;
        this.last = last;
        this.increment = increment;
    }

    /**
     * 如果last和first小于10，
     * 一任务只能更新少于10件产品的价格
     * 否则创建两个Task,一个处理前一半，另一个处理后一半
     * 然后invokeAll()方法
     */
    @Override
    protected void compute() {
        if (last - first < 10) {
            updatePrices();
        } else {
            int middle = (last + first) / 2;
            System.out.printf("Task:Pending tasks:%s\n", getQueuedTaskCount());
            Task t1 = new Task(products, first, middle + 1, increment);
            Task t2 = new Task(products, middle + 1, last, increment);
            invokeAll(t1, t2);
        }
    }
    private void updatePrices(){
        for (int i=first;i<last;i++) {
            Product product = products.get(i);
            product.setPrice(product.getPrice()*(1+increment));
        }
    }
}
