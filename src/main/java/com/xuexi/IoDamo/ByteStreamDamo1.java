package com.xuexi.IoDamo;

import java.io.*;

public class ByteStreamDamo1 {
    public static void main(String[] args) throws IOException {
        /*
        *
        *       字节流：拷贝任意类型的文件
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
        *
        *       =========================================================
        *
        *       字节输入流的细节：
        *               创建对象：
        *                       如果文件不存在就会报错
        *               读取数据：
        *                       一次读取一个字节，读取出来的是对应在ASCII表上对应的数字
        *                       读到文件末尾会返回-1
        *               释放资源：
        *                       每次操作完成之后都要使用close()方法释放资源，否则java会一直占用对应的资源
        *
        *       读取数据的方法：
        *               int read()              每次读取一个字节数据，读取到末尾时返回-1
        *               int read(Byet[] byet)   每次读取多个数据，每次返回读取到字节的个数，读取到末尾时返回-1
        *                       具体一次读取多少个字节数据，跟数组长度有关
        *                       每次读取的长度最多不超过数组的长度
        *
        * */

        //1.创建输出流对象
        FileOutputStream fileOutput = new FileOutputStream(new File("src/main/java/com/xuexi/IoDamo/text.txt"));
        //2.写数据
        fileOutput.write(97);
        String str = "abcde";
        fileOutput.write(str.getBytes());

        FileOutputStream fileOut = new FileOutputStream(new File("src/main/java/com/xuexi/IoDamo/text.txt"), true);
        fileOutput.write("\r\n".getBytes());
        String s = "abcde";
        fileOutput.write(s.getBytes());

        //3.释放资源
        fileOutput.close();

        System.out.println("================================");

        //创建输入流对象
        FileInputStream fileInput = new FileInputStream("src/main/java/com/xuexi/IoDamo/text.txt");
        //读取数据
        //System.out.println((char)fileInput.read());
        byte[] b = new byte[2];
        int len = fileInput.read(b);
        System.out.println(new String(b, 0, len));
        //释放资源
        fileInput.close();

    }
}
