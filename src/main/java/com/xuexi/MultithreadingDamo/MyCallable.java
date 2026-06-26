package com.xuexi.MultithreadingDamo;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {

        //线程执行的代码
        int sum = 0;
        for (int i = 0; i <= 10; i++) {
            sum += i;
        }
        return sum;

    }

}
