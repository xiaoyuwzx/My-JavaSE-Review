package com.xuexi.IoDamo;

import java.io.*;

public class PrintStreamDamo1 {
    public static void main(String[] args) throws IOException {
        /*
        *
        *           字节打印流：
        *               构造方法：
        *                       public PrintStream(OutputStream/File/String)                                关联字节输出流/文件/文件路径
        *                       public PrintStream(String fileName, Charset charset)                        指定字符编码
        *                       public PrintStream(OutputStream out, boolean autoFlush)                     自动刷新
        *                       public PrintStream(OutputStream out, boolean autoFlush, String encoding)    指定字符编码且自动刷新
        *
        *               成员方法：
        *                   常规方法：
        *                       public void write(int b)                            将指定字节写出
        *                   特有方法：
        *                       public void println()                               打印任意数据，自动刷新，自动换行
        *                       public void print()                                 打印任意数据，不换行
        *                       public void printf(String format, Object... args)   带有占位符的打印语句，不换行
        *
        *           =====================================
        *
        *           字符打印流：
        *               构造方法：
        *                       public PrintWriter(Writer/File/String)                                      关联字节输出流/文件/文件路径
        *                       public PrintWriter(String fileName, Charset charset)                        指定字符编码
        *                       public PrintWriter(Writer out, boolean autoFlush)                     自动刷新
        *                       public PrintWriter(Writer out, boolean autoFlush, String encoding)    指定字符编码且自动刷新
        *
        *               成员方法：
        *                   常规方法：
        *                       public void write(int b)                            将指定字节写出
        *                   特有方法：
        *                       public void println()                               打印任意数据，自动刷新，自动换行
        *                       public void print()                                 打印任意数据，不换行
        *                       public void printf(String format, Object... args)   带有占位符的打印语句，不换行
        *
        * */

        //创建字节打印流对象
        PrintStream ps = new PrintStream(new FileOutputStream("src/main/java/com/xuexi/IoDamo/text.txt"), true,  "UTF-8");
        //写出数据
        ps.println(97);
        //释放资源
        ps.close();


        //创建字符打印流对象
        PrintWriter pw = new PrintWriter(new FileWriter("src/main/java/com/xuexi/IoDamo/text.txt"), true);
        //写出数据
        pw.println(98);
        //释放资源
        pw.close();

    }
}
