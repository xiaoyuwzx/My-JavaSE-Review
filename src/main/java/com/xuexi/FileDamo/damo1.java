package com.xuexi.FileDamo;

import java.io.File;

public class damo1 {
    public static void main(String[] args) {
        /*
        *
        *       public File(String pathname)                根据文件路径创建文件对象
        *       public File(String parent, String child)    根据父路径名字字符串和子路径字符串创建文件对象
        *       public File(File parent, String child)      根据父路径对应文件对象和子路径字符串创建对象
        *
        * */

        //根据文件路径创建文件对象
        String pathname = "D:\\java\\ideaprojects\\JavaSE-Review\\src\\main\\java\\com\\xuexi\\FileDamo\\damo1.java";
        File file1 = new File(pathname);
        System.out.println(file1);

        //根据父路径名字字符串和子路径字符串创建文件对象
        String parent = "D:\\java\\ideaprojects\\JavaSE-Review\\src\\main\\java\\com\\xuexi\\FileDamo";
        String child = "damo1.java";
        File file2 = new File(parent, child);
        System.out.println(file2);

        //根据父路径对应文件对象和子路径字符串创建对象
        File file3 = new File("D:\\java\\ideaprojects\\JavaSE-Review\\src\\main\\java\\com\\xuexi\\FileDamo");
        String chile2 = "damo1.java";
        File file4 = new File(file3, chile2);
        System.out.println(file4);

    }
}
