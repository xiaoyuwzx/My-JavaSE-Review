package com.xuexi.IoDamo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharStreamDamo1 {
    public static void main(String[] args) throws IOException {

        /*
        *
        *           字符流：读取纯文本文件中的数据
        *                   往纯文本文件中写入数据
        *
        *           字符输入流细节：
        *               创建对象：
        *                   public FileReader(File file)            创建字符输入流管理本地文件
        *                   public FileReader(String pathname)
        *                   JDK11：创建对象的时候可以指定字符编码
        *                       FileReader fileReader = new FileReader("file", Charset.forname("编码格式"));
        *               读取数据：
        *                   public int read()                       读取数据，读到末尾反复-1
        *                           字符流的底层也是字节流，默认也是一个字节一个字节的读取
        *                           遇到中文读取多个，GDK编码的一次读取2个字节，UDF-8一次读取3个字节
        *                           read 方法的返回值的是读取之后将二进制进行解码后的十进制数字
        *                           想要看到字符使用强转就可以看到
        *                   public int read(char[] buffer)          读取多个数据，读到末尾返回-1
        *                           带参的 read 方法是将 强转后的字符存放在数组中
        *                           带参的 read 方法就相当于 空参的 read 方法 + 强制转换
        *
        *               释放资源：
        *                   public void close()                     释放资源/关流
        *
        *
        *           ========================================
        *
        *           字符输出流的细节：
        *               创建字符输出流对象：
        *                        参数是字符串表示的路径或者是File对象都可以
        *                        如果文件不存在则会创建一个新的，但是要保证父级路径是存在的
        *                        如果文件存在这流会先清空文件再进行操作，如果不想则可以打开续写开关
        *               写数据：
        *                        write方法的参数是整数，但写到文件中的是这个整数在字符集中对应的字符
        *               释放资源：
        *                       每次操作完成之后都要使用close()方法释放资源，否则java会一直占用对应的资源
        *
        *           字符输出流的构造方法：
        *                   public FileWriter(File file)                        创建字符输出流关联本地文件
        *                   public FileWriter(String pathname)                  创建字符输出流关联本地文件
        *                   public FileWriter(File file, boolean append)        创建字符输出流关联本地文件，续写
        *                   public FileWriter(String pathname, boolean append)  创建字符输出流关联本地文件，续写
        *                   JDK11：创建对象的时候可以指定字符编码
         *                       FileWriter fileWriter = new FileWriter("file", Charset.forname("编码格式"));
        *           成员方法：
        *               void write(int c)                               写出一个字符
        *               void write(String str)                          写出一个字符串
        *               void write(String str, int off, int len)        写出字符串的一部分
        *               void write(char[] cbuf)                         写出一个字符串数组
        *               void write(char[] cbuf, int off, int len)       写出字符数组的一部分
        *
        * */

        //创建对象
        FileReader fileReader = new FileReader("src/main/java/com/xuexi/IoDamo/text.txt");
        //读取数据
        /*int ch;
        while ((ch = fileReader.read()) != -1){
            System.out.print((char)ch);
        }*/
        char[] ch = new char[2];
        int len = 0;
        while ((len = fileReader.read(ch)) != -1){
            System.out.print(new String(ch, 0, len));
        }
        //释放资源
        fileReader.close();

        System.out.println("\n=========================");

        //创建输出流
        FileWriter fileWriter = new FileWriter("src/main/java/com/xuexi/IoDamo/text.txt", true);
        //输入数据
        //fileWriter.write("Java你好");
        char[] c = {'a', 'b', 'c', '我'};
        fileWriter.write(c);
        //释放资源
        fileWriter.close();

    }
}
