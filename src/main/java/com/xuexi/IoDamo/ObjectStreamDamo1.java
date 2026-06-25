package com.xuexi.IoDamo;

import java.io.*;

public class ObjectStreamDamo1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        /*
        *
        *           序列化流/对象操作输出流：
        *                   public ObjectOutputStream(OutputStream out)     把基本流包装成高级流
        *           成员方法：
        *                   public final void writeObject(Objcet obj)       把对象序列化(写出)到文件中
        *                   细节：
        *                       使用对象输出流将对象保存到文件中时会出现 NotSerializableException 异常
        *                       此时需要让需要序列化的对象类实现 · 接口
        *
        *           反序列化流/对象操作输入流：
        *                   public ObjectInputStream(InputStream out)       把基本流包装成高级流
        *           成员方法：
        *                   public Object readObject()                      把序列化到本地文件中的对象，读取到程序中来
        *                   细节：
        *                       如果需要将一个JavaBean类对象从本地文件中反序列化到程序中时
        *                       如果此时类中被修改了会抛出InvalidClassException异常
        *                       此时如果想成功序列化数据到重新中则需要在序列化前手动定义一个 serialVersionUID 来固定次类的UID;
        *                       private static final long serialVersionUID = (手动定义的UID)L;
        *
        *           细节：
        *               transient关键字：瞬态关键字
        *               作用：不会把当前属性序列化到本地文件中
        *               如果不想把一些属性序列化到本地文件中时，需要在类中的对应属性前面添加transient关键字
        *
        *               序列化流写到文件中的数据是不能修改的，一旦修改就无法再读回来数据了
        *
        *
        * */

        //序列化对象
        //创建对象
        Student student = new Student("张三", 27);
        //创建序列化流的对象/对象操作输出流
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("src/main/java/com/xuexi/IoDamo/text.txt"));
        //写出数据
        outputStream.writeObject(student);
        //释放资源
        outputStream.close();

        //反序列化对象
        //创建反序列化流对象
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("src/main/java/com/xuexi/IoDamo/text.txt"));
        //读取数据
        Student stu = (Student) inputStream.readObject();
        //打印数据并释放资源
        System.out.println(stu);
        inputStream.close();

    }
}
