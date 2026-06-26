package com.xuexi.IoDamo;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipStreamDamo1 {
    public static void main(String[] args) throws IOException {
        /*
        *
        *       解压缩流：
        *           public ZipInputStream(FileInputStream file)
        *
        *       压缩流：
        *
        *
        * */

       /* //创建File对象表示要压缩的文件夹
        File src = new File("D:\\java\\ideaprojects\\JavaSE-Review\\src\\main\\java\\com\\xuexi\\IoDamo\\aaa");
        //创建File对象表示压缩包放在哪里(压缩包的父级路径)
        File destParent = src.getParentFile();
        //创建File对象表示压缩包的路径
        File dest = new File(destParent, src.getName() + ".zip");
        //创建压缩了关联压缩包
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(dest));
        //获取src中的每一个文件，变成ZipEntry对象，放到压缩包中
        toZip(src, zipOutputStream, src.getName());
        //释放资源
        zipOutputStream.close();*/

        File zipSrc = new File("D:\\java\\ideaprojects\\JavaSE-Review\\src\\main\\java\\com\\xuexi\\IoDamo\\aaa.zip");
        File zipDest = new File("D:\\java\\ideaprojects\\JavaSE-Review\\src\\main\\java\\com\\xuexi\\IoDamo\\");
        unzip(zipSrc, zipDest);

    }

    //定义一个方法来压缩文件(name为压缩包内部的路径)
    private static void toZip(File src, ZipOutputStream zipOutputStream, String name) throws IOException {
        //进入src文件夹
        File[] files = src.listFiles();
        //遍历数组
        for (File file : files) {
            if(file.isFile()){
                //判断是文件：变成ZipEntry对象放到压缩包中
                ZipEntry zipEntry = new ZipEntry(name + "\\" + file.getName());
                zipOutputStream.putNextEntry(zipEntry);
                //读取文件中的数据，写到压缩包中
                FileInputStream fileInputStream = new FileInputStream(file);
                int b;
                while ((b = fileInputStream.read()) != -1) {
                    zipOutputStream.write(b);
                }
                fileInputStream.close();
                zipOutputStream.closeEntry();
            }else{
                //判断是文件夹
                toZip(file, zipOutputStream, name + "\\" + file.getName());
            }
        }
    }

    //定义一个方法用来解压
    public static void unzip(File src, File dest) throws IOException {
        //解压的本质：把压缩包里的每一个文件或者文件夹读取出来，按照层级拷贝到目的地当中
        //创建一个解压缩流来读取压缩包中的数据
        ZipInputStream zip = new ZipInputStream(new FileInputStream(src));
        //要先获取到压缩包里面的每一个 zip entry对象
        ZipEntry zipEntry;
        while ((zipEntry = zip.getNextEntry()) != null) {
            if(zipEntry.isDirectory()) {
                //是文件夹：需要在目的地dest出创建一个同样的文件夹
                File file = new File(dest, zipEntry.toString());
                file.mkdirs();
            }else {
                //是文件：需要读取压缩包中的文件，并把它存放到目的地dest文件夹相同路径中
                FileOutputStream fileOutputStream = new FileOutputStream(new File(dest, zipEntry.toString()));
                int b;
                while ((b = zip.read()) != -1){
                    //写到目的地
                    fileOutputStream.write(b);
                }
                fileOutputStream.close();
                zip.closeEntry();
            }
        }
        zip.close();
    }

}
