package com.xuexi.StreamDamo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamDamo {
    public static void main(String[] args) {
        /*
        *  使用 Stream 流
         */
        int test = 3;
        if(test == 1) damo1();
        else if(test == 2) damo2();
        else if(test == 3) damo3();
        else if(test == 4) damo4();
    }

    //单列集合
    private static void damo1() {
        /*
        *   单列集合创建数据流直接调用 Collection 中的默认方法 stream
        * */
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5);
        //方法一
        //获取一条流水线，把集合中的元素都放到流水线上
        Stream<Integer> stream = list.stream();
        //使用终结方法打印流水线上的所以数据
        stream.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
        System.out.println("===========================");
        //方法二
        list.stream().forEach(s -> System.out.println(s));
    }
    //双列集合
    private static void damo2() {
        /*
        * 双列集合创建数据流不能直接使用，需要转化成单列集合后再使用
        * 使用 keySet() 方法和 entrySet()
        * */
        HashMap<String, String> map = new HashMap<>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");
        //方法一
        //使用 keySet() 方法 将键提取出来
        map.keySet().stream().forEach(s -> System.out.println(s + " : " + map.get(s)));
        System.out.println("===================");
        //方法二
        //使用 entrySet() 方法将键值对提前出来
        map.entrySet().stream().forEach(s -> System.out.println(s));
    }
    //数组
    private static void damo3() {
        /*
        * 数组创建 Stream 流直接使用 Arrays 中的 stream 方法
        * */
        String[] str = {"aaa", "bbb", "ccc"};
        Arrays.stream(str).forEach(s -> System.out.println(s));
        System.out.println("=================");
        // 数组也可以直接调用 Stream 中的静态方法 of() 来创建数据
        // 但是数组中的数据不能是基本数据类型的数据
        // 否则会把整个数组当成一个数据放到Stream流中会输出地址值
        Stream.of(str).forEach(s -> System.out.println(s));
    }
    //一堆零散数据
    private static void damo4() {
        /*
        * 一堆零散数据想创建 Stream 流 需要调用 Stream 中的静态方法 of()
        * */
        Stream.of(1, 2, 3, 4, 5).forEach(s -> System.out.println(s));
    }
}
