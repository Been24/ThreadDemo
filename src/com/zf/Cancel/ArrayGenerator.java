package com.zf.Cancel;

import java.util.Random;

/**
 * Created by Been on 2018/5/30.
 */
public class ArrayGenerator {
    public int[] generateArray(int size) {
        int array[] = new int[size];
        Random random = new Random();
        for (int i=0;i<size;i++) {
            array[i] = random.nextInt(10);
        }
        return array;
    }
}
