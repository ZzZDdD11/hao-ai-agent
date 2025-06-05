package org.example.haoaiagent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SteamDemo1 {
    public static void main(String[] args) {
        // 创建获取stream流
        // 1. 单列集合自带此方法
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list, "张无忌-男-15", "周芷若-女-14", "赵敏-女-40", "张三丰-男-39");
        System.out.println(list);

        Object[] array = list.stream().toArray();
        System.out.println(Arrays.toString(array));

        String[] array1 = list.stream().toArray(value -> new String[value]);
        System.out.println(Arrays.toString(array1));

        // count
        long count = Arrays.stream(array1).count();
        System.out.println(count);

        list.stream()
                .map(s -> Integer.parseInt(s.split("-")[1])).forEach(s-> System.out.println(s));


        //collect运用
        List<String> newList = list.stream().filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toList());



    }
}
