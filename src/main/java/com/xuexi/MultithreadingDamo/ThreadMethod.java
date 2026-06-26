package com.xuexi.MultithreadingDamo;

public class ThreadMethod {
    public static void main(String[] args) {
        /*
        *
        *          常见的成员方法：
        *               String getName()                    返回此线程的名称
        *               void setName(String name)           设置线程的名字(构造方法也可以设置名字)
        *                   细节：
        *                       如果没有给线程设置名字，线程会有默认的名字
        *                           格式：Thread-X(X序号，从0开始)
        *                       如果要给线程设置名字，可以使用setName方法进行设置，也可以通过构造方法设置
        *
        *               static Thread currentThread()       获取当前线程的对象
        *                   细节：
        *                       当JVM虚拟机启动后，会自动的启动多条线程
        *                       其中就有main线程，启动后会自动执行里面的代码
        *               static void sleep(long time)        让线程休眠指定的时间，单位为毫秒
        *                   细节：
        *                       当某条线程执行到此方法时，这条线程就会停留对应的时间
        *                       当时间到了后线程会自动醒来，并继续执行下面的其他代码
        *
        *               setPriority(int newPriority)        设置线程的优先级
        *                   细节：
        *                       Java采用的是抢占式调度
        *                       Java中线程的默认优先级为 5
        *                                      最低为   1
        *                                      最高为   10
        *               final int getPriority()             获取线程的优先级
        *               final void setDaemon(boolean on)    设置为守护线程
        *                   细节：
        *                       当其他非守护线程执行完毕之后，守护线程会陆续结束执行(不会立刻停止，会等待非守护线程执行完毕的命令来之后才结束)
        *               public static void yield()          出让线程/礼让线程
        *                   细节：
        *                       当线程执行了出让/礼让方法后会让出CPU重新进行抢夺
        *               public static void join()           插入线程/插队线程
        *                   细节：
        *                       当线程执行了插入/插队方法之后，会插入到当前线程之前，此时会在插入线程执行完之后才执行当前线程
        *
        * */
    }
}
