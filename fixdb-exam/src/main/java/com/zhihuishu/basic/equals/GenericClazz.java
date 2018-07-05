package com.zhihuishu.basic.equals;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/3.
 * 泛型
 */
public class GenericClazz {
    public static void main(String[] args) {
        Integer[] arr = {10,2,3,54,9};
        Integer min = min(arr);
        System.out.println(min+"***********");
    }
    // 取最小值 T 是代表一个类型 extends Comparable代表 T 是Comparable的字类型
    public static <T extends Comparable & Serializable> T min(T[] a) {
        if (a == null || a.length == 0) return null;
        T smallest = a[0];
        for (int i = 1; i < a.length; i++) {
            if (smallest.compareTo(a[i]) > 0) smallest = a[i];
        }
        return smallest;
    }

    public static List<?>[] createGenerateArr(int size) {
        List<?>[] array = new ArrayList<?>[size];
        return array;
    }
}
