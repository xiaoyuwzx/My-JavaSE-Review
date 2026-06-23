package com.xuexi.MapText;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionsText {
    public static void main(String[] args){

        ArrayList<String> list = new ArrayList<>();

        //批量添加
        Collections.addAll(list, "123", "abc", "qqq");
        System.out.println(list);

        //shuffle 打乱
        Collections.shuffle(list);
        System.out.println(list);

        //排序（自定义类需要重写Comparable中的compareTo方法）
        //自定义排序（重写Comparator接口的compare方法）
        Collections.sort(list);
        System.out.println(list);

        //二分查找元素，集合需有序
        System.out.println(Collections.binarySearch(list, "qqq"));

        //拷贝集合元素
        //copyList集合中的元素会被覆盖，并且copyList.size() >= list.size()
        ArrayList<String> copyList  = new ArrayList<>();
        Collections.addAll(copyList, "", "", "");
        Collections.copy(copyList, list);
        System.out.println(copyList);

        //fill 指定元素填充集合
        Collections.fill(list, "a");
        System.out.println(list);

        //获取自然排序的最大/最小值
        System.out.println(Collections.max(copyList));
        System.out.println(Collections.min(copyList));

        //交换集合中的指定元素
        System.out.println(copyList);
        Collections.swap(copyList, 0, 2);
        System.out.println(copyList);

    }
}