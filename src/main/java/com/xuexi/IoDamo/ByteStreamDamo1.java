package com.xuexi.IoDamo;

import java.io.*;

public class ByteStreamDamo1 {
    public static void main(String[] args) throws IOException {
        /*
        *
        *       字节输出流的细节：
        *           创建字节输出流对象：
        *               参数是字符串表示的路径或者是File对象都可以
        *               如果文件不存在则会创建一个新的，但是要保证父级路径是存在的
        *               如果文件存在这流会先清空文件再进行操作
        *           写数据：
        *               write方法的参数是整数，但写到文件中的是这个整数在ASCII表中对应的字符
        *           释放资源：
        *               每次操作完成之后都要使用close()方法释放资源，否则java会一直占用对应的资源
        *
        *
        *       写数据的三张方法：
        *               void write(int b)                       一次写一个字节数据
        *               void write(byte[] b)                    一次写一个字节数组的数据
        *                       写人多个数据的时候可以使用String字符串的getBytes()方法便捷生成对应的字节数组
        *               void write(byte[] b, int off, int len   一次写一个自己数组的部分数据(off是起始索引， len是个数)
        *
        *       换行：
        *               写入一个 换行符 就可以实现换行写入
        *
        *       续写：
        *               想不清空文件内容进行续写的话只需要打开续写开关就可以了
        *               续写开关为 FileOutputStream 对象的第二个参数，将第二个参数设置为 True 就可以在不清空文件的情况下进行写入
        *               续写开关默认为 false
        *
        * */

        //1.创建对象
        FileOutputStream file = new FileOutputStream(new File("src/main/java/com/xuexi/IoDamo/text.txt"));
        //2.写数据
        file.write(97);
        String str = "abcde";
        file.write(str.getBytes());

        FileOutputStream fileOut = new FileOutputStream(new File("src/main/java/com/xuexi/IoDamo/text.txt"), true);
        file.write("\r\n".getBytes());
        String s = "abcde";
        file.write(s.getBytes());

        //3.释放资源
        file.close();

    }
}
