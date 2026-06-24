package com.xuexi.StreamDamo;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

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
        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1, "张无忌-男-15", "张无忌-男-15", "周若芷-女-30", "张强-男-35", "张三丰-男-10", "张翠山-男-50", "张良-男-100");
        //收集到List集合中
        //底层会创建一个ArrayList集合
        List<String> toList = list1.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toList());
        System.out.println(toList);

        System.out.println("-----------------");

        //收集到Set集合中
        //底层会创建一个HashSet集合，同时会对数据去重
        Set<String> set = list1.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toSet());
        System.out.println(set);

        System.out.println("-----------------");

        //收集到Map集合中
        //此时数据中充当键的数据不能重复，否则会报错
        ArrayList<String> list2 = new ArrayList<>();
        Collections.addAll(list2, "张无忌-男-15", "周若芷-女-30", "张强-男-35", "张三丰-男-10", "张翠山-男-50", "张良-男-100");
        /*Map<String, Integer> map = list2.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toMap(
                        //此时第一个参数为没一个数据的类型
                        //第二个参数为返回值的类型，也就是键和值的数据类型
                        new Function<String, String>() {
                            @Override
                            public String apply(String s) {
                                return s.split("-")[0];
                            }
                        },
                        new Function<String, Integer>() {
                            @Override
                            public Integer apply(String s) {
                                return Integer.parseInt(s.split("-")[2]);
                            }
                        }
                ));
        System.out.println(map);*/
        Map<String, Integer> map = list2.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toMap(s -> s.split("-")[0],
                        s -> Integer.parseInt(s.split("-")[2])));
        System.out.println(map);

    }
}
