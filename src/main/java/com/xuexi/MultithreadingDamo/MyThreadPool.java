package com.xuexi.MultithreadingDamo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPool {
    public static void main(String[] args) {
        /*
        *
        *           线程池的构建：
        *                   public static ExecutorService newCachedThreadPool()             创建一个没有上限的线程池
        *                       ExecutorService pool = Executors.newCachedThreadPool();
        *                   public static ExecutorService newFixedThreadPool(int nThreads)  创建有上限的线程池
        *                       ExecutorService pool = Executors.newFixedThreadPool(int nThreads);
        *           成员方法：
        *                   pool.submit(Thread)         将线程提交到线程池中
        *                   pool.shutdown()             销毁线程池
        *           原理：
        *               创建一个池子，池子中是空的
        *               提交任务时，池子会创建新的线程对象，任务执行完毕后线程会归还给池子
        *               下次再次提交任务时，不需要再次创建新的线程，直接复用已有的线程即可
        *               但是如果提交任务时，池子里面没有空闲的线程，并且无法创建新线程时，任务会排队等待
        *
        *           自定义线程池：
        *               构建方法：
        *                   ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor
        *                   (核心线程数量，最大线程数量，空闲线程最大存活时间，最大存活时间单位，任务队列，创建线程工厂，任务的拒绝策略)
        *                   参数一：核心线程数量              不能小于0
        *                   参数二：最大线程数                不能小于0，并且最大数量 >= 核心线程数量
        *                   参数三：空闲线程最大存活时间       不能小于0
        *                   参数四：时间单位                  用TimeUnit指定
        *                   参数五：任务队列                  不能为null
        *                   参数六：创建线程工厂              不能为null
        *                   参数七：任务的拒绝策略             不能为null
        *
        *
        *           本机最大并行数：
        *                   Runtime.getRuntime().availableProcessors()
        *
        * */

        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3,                          //核心线程数量
                6,                                      //最大线程数
                60,                                     //空闲线程最大存活时间
                TimeUnit.SECONDS,                       //时间单位
                new ArrayBlockingQueue<>(3),   //任务队列
                Executors.defaultThreadFactory(),       //创建线程工厂
                new ThreadPoolExecutor.AbortPolicy()    //任务的拒绝策略
        );

    }
}
