package com.xuexi.ExceptionDamo;

public class damo1 {
    /*
    *
    *       关键字：
    *               throw / throws       抛出异常
    *                   throws：      写在方法定义出，表示声明异常，告诉调用者此方法会出现哪些异常(多个异常以 ， 隔开)
    *                   throw:        写在方法内，结束方法，手动抛出异常对象给调用者，并结束下面代码
    *               try         捕捉异常
    *               catch       处理异常
    *       格式：
    *           thy{
    *               可能出现异常的代码
    *           }catch(异常类名  变量名){
    *               异常的处理代码
    *           }
    *
    *       常见的方法：
    *           public String getMessage()      返回此throwable的详细消息字符串
    *           public String toString()        返回此可抛出异常的简短描述
    *           public void printStackTrace()   把异常的错误信息输出在控制台  (底层是以System.err.println的方式把错误信息以红色字体在控制台输出)
    *                                           (仅打印错误信息，不会像JVM虚拟机默认方法一样结束程序运行)
    *
    *       自定义异常：   (为了让控制台的报错信息更加见名之意)
    *               定义异常类：一般以Exception为后缀
    *               写继承关系：运行时异常继承RuntimeException, 编译时异常继承Exception
    *               空参构造
    *               带参构造
    *
    * */
    public static void main(String[] args) {

        int[] arr = {1, 2, 3};

        try {
            System.out.println(arr[10]);
        }catch (ArrayIndexOutOfBoundsException e){

            //System.out.println(e.getMessage());  //Index 10 out of bounds for length 3

            //System.out.println(e.toString());  //java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 3

            e.printStackTrace();  //java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 3
                                  //    at com.xuexi.ExceptionDamo.damo1.main(damo1.java:29)


        }

        System.out.println("看我执行了吗");

    }
}
