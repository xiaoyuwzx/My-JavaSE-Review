package com.xuexi.FunctionDamo;

import java.util.Arrays;
import java.util.Comparator;

public class Damo1 {
    public static void main(String[] args) {
        /*
        *
        *   方法引用: 把已经存在的方法拿过来直接用，当作函数式接口中抽象方法的方法体
        *
        *       ：：  为方法引用符
        *
        *   使用注意：
        *       必须要在函数式接口中使用
        *       使用的方法必须已经定义
        *       被引用的方法的形参和返回值都必须与抽象方法保持一致
        *       被引用的方法必须能够完成抽象方法当前的需求
        *
        *   引用方法类型：
        *       引用静态方法：
        *                       类名::方法名
        *       引用成员方法：
        *           其他类：    其他类对象::方法名
        *           本类：      this::方法名  (引用出要是非静态的，静态方法没有this关键字)
        *           父类：      super::方法名  (引用出要是非静态的，静态方法没有this关键字)
        *       引用构造方法：
        *                       类名::new   (表示创建这个咧的对象)
        *       类名引用成员方法：
        *                       类名::方法名
        *            注意： 这种使用方法的类名需要更Stream流中的数据类型相同，只能使用流中数据类型的方法，
        *                  并且第二个参数参数到最后一个参数需要跟被引用方法的形参保持一致，如果没有第二个参数，
        *                   则只能使用类中 无参 的成员方法
        *            局限性： 不能引用所有类中的成员方法
        *                    跟抽象方法的第一个参数有关，这个参数是什么类型的就只能使用这个类中的方法
        *       引用数组的构造方法：
        *                       数据类型[]::new   (数组的类型需要跟流中数据的类型报错相同)
        *
        * */

        Integer[] arr = {1,2,3,4,5,6};

        //排序
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        //lambda表达式
        Arrays.sort(arr, (o1, o2) -> o2 - o1);

        //方法引用
        Arrays.sort(arr, Damo1::subtraction);

        System.out.println(Arrays.toString(arr));

    }
    public static int subtraction(int n1, int n2){
        return n2 - n1;
    }
}
