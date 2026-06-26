package com.xuexi.MultithreadingDamo;

public class MyRun implements  Runnable{

    @Override
    public void run() {

        //线程需要执行的代码
        for (int i = 0; i < 10; i++) {
            //获取当前线程的对象
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName() + "Hello Java");
        }

    }

}
