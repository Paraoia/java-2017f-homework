package com.zy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Sort {
    public static void main(String[] args) {
        // 产生一系列随机数
        List<Integer> intArray = new ArrayList<>();
        Random random = new Random();
        int count = random.nextInt(90) + 10;
        for (int i = 0; i < count; i++)
            intArray.add(random.nextInt(100));
        // 输出数据
        System.out.println("count: " + count);
        System.out.println("array: " + intArray);
        // 开始排序
        System.out.println("sorting");
        Collections.sort(intArray);
        // 输出结果
        System.out.println("count: " + count);
        System.out.println("array: " + intArray);
    }
}
