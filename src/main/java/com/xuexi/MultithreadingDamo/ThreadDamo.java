package com.xuexi.MultithreadingDamo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDamo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
        *
        *   多线程的实现方式：
        *           继承Thread类的方式进行实现：
        *                   自己定义一个类继承Thread
        *                   重新run方法
        *                   创建子类的对象，并启动多线程
        *
        *           实现Runnable接口的方式进行实现：
        *                   自己定义一个类实现Runnable接口
        *                   重新里面的run方法
        *                   创建自己类的对象
        *                   创建一个Thread类的对象，并开启线程
        *
        *           利用Callable接口和Future接口进行实现：
        *                   (特点：可以获取到多线程运行的结果)
        *                   创建一个类实现Callable接口
        *                   重新call(有返回值， 表示多线程运行的结果)
        *                   创建类的对象(表示多线程要执行的任务)
        *                   创建FutureTask的对象(表示管理多线程运行的结果)
        *                   创建Thread类的对象，并启动(表示线程)
        *
        *       三种方式的对比：
        *                                          优点                                            缺点
        *               继承Thread类    编程比较简单，可以直接使用Thread类中的方法       可扩展性较差，不能再继承其他的类
        *
        *             实现Runnable接口  扩展性强，实现该接口的同时还可以继承其他的类      编程相对复杂，不能直接使用Thread类中的方法
        *            和实现Callable接口
        *
        * */

        //damo1();
        //damo2();
        damo3();

    }

    //继承Thread类的方式实现多线程
    private static void damo1() {

        //定义子类对象
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        //设置线程的名字
        t1.setName("线程1");
        t2.setName("线程2");

        //执行线程
        t1.start();
        t2.start();

    }

    //实现Runnable接口的方式实现多线程
    private static void damo2() {

        //创建类的对象表示多线程需要执行的任务
        MyRun myRun = new MyRun();

        //创建线程对象
        Thread t1 = new Thread(myRun);
        Thread t2 = new Thread(myRun);

        //设置线程的名字
        t1.setName("线程1");
        t2.setName("线程2");

        //开启线程
        t1.start();
        t2.start();

    }

    //利用Callable接口和Future接口实现多线程
    private static void damo3() throws ExecutionException, InterruptedException {

        // 创建类的对象(表示多线程要执行的任务)
        MyCallable myCallable = new MyCallable();

        // 创建FutureTask的对象(表示管理多线程运行的结果)
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);

        //创建线程的对象
        Thread t1 = new Thread(futureTask);

        //启动线程
        t1.start();

        //获取多线程运行的结果
        System.out.println(futureTask.get());

    }

}
