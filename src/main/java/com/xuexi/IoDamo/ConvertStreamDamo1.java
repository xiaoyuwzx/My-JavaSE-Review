package com.xuexi.IoDamo;

import java.io.*;

public class ConvertStreamDamo1 {
    public static void main(String[] args) throws IOException {
        /*
        *
        *           转换输入流：
        *               InputStreamReader
        *               使用指定编码格式读取文件内容：
        *                   InputStreamReader input = new InputStreamReader(new FileInputStream("file"), "编码格式");
        *           转换输出流：
        *               OutputStreamWriter
        *               使用指定编码格式写出数据：
        *                   OutputStreamWriter output = new OutputStreamWriter(new FileOutputStream("file"), "编码格式");
        *
        *
        * */

        //利用字节流读取文件中的数据，每次读取一行并且不会出现乱码

        /*FileInputStream fileInputStream = new FileInputStream("src/main/java/com/xuexi/IoDamo/text.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str = bufferedReader.readLine();
        System.out.println(str);
        bufferedReader.close();*/

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/com/xuexi/IoDamo/text.txt")));
        String line;
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }
        bufferedReader.close();

    }
}
