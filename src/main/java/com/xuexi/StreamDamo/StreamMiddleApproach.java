package com.xuexi.StreamDamo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

public class StreamMiddleApproach {
    public static void main(String[] args) {

        /*
        *       过滤              filter
        *       获取前几个元素     limit
        *       跳过前几个元素     skip
        *       元素去重           distinct     依赖于 HashCode 和 equals 方法
        *       合并a和b两个流     concat        Stream的静态方法
        *       转换流中的数据类型  map
        * */

        /*
        *   中间方法，返回新的数据流后，原来的数据流就会被销毁也就是只能使用一次
        *   修改 Stream 流中的数据，不会影响原来集合或者数组中的数据
        * */

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "张无忌", "周若芷", "张强", "张三丰", "张翠山", "张良");

        //过滤
        list.stream()
                .filter(s -> s.startsWith("张"))
                .filter(s -> s.length() == 3)
                .forEach(s -> System.out.println(s));

        System.out.println("==================");

        //获取前几个元素
        list.stream().limit(3).forEach(s -> System.out.println(s));

        System.out.println("==================");

        //跳过前几个元素
        list.stream().skip(3).forEach(s -> System.out.println(s));

        System.out.println("==================");

        //元素去重
        list.stream().distinct().forEach(s -> System.out.println(s));

        System.out.println("==================");

        //合并 a 和 b 两个流
        //如果 a 和 b 的数据类型不同，合并后流的数据类型为两者共同的 父类
        ArrayList<String> newList = new ArrayList<>();
        Collections.addAll(list, "张三", "谢广坤");
        Stream.concat(list.stream(), newList.stream()).forEach(s -> System.out.println(s));

        System.out.println("==================");

        //转换流中的数据类型
        ArrayList<String> toList = new ArrayList<>();
        Collections.addAll(toList, "张无忌-15", "周若芷-20", "张强-3", "张三丰-50");
        /*toList.stream().map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s.split("-")[1]);
            }
        }).forEach(s -> System.out.println(s));*/
        toList.stream()
                .map(s -> Integer.parseInt(s.split("-")[1]))
                .forEach(s -> System.out.println(s));
    }
}
