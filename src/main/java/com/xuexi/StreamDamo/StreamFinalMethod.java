package com.xuexi.StreamDamo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.function.IntFunction;

public class StreamFinalMethod {
    public static void main(String[] args) {

        /*
        *       void forEach(Consumer action)       遍历
        *       long count()                        统计个数
        *       toArray()                           收集流中的数据，放到一个数组中
        *       collect(Collector collector)        收集流中的数据，放到一个集合中
        * */

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "张无忌", "周若芷", "张强", "张三丰", "张翠山", "张良");

        //遍历
        /*list.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });*/
        list.stream().forEach(s -> System.out.println(s));

        System.out.println("================");

        //统计个数
        long count = list.stream().count();
        System.out.println(count);

        System.out.println("================");

        //收集流中的数据，放到数组中
        /*String[] arr = list.stream().toArray(new IntFunction<String[]>() {
            @Override
            public String[] apply(int value) {
                return new String[value];
            }
        });
        System.out.println(Arrays.toString(arr));*/
        // toArray 方法中的 value 为流中数据的个数，表示创建一个长度为 value 的数组
        // 创建的数组长度要和流中数据的个数相等
        String[] arr = list.stream().toArray(value -> new String[value]);
        System.out.println(Arrays.toString(arr));

        System.out.println("================");

        //收集流中的数据，放到集合中

    }
}
