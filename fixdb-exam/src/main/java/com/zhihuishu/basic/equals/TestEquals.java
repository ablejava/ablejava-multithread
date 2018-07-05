package com.zhihuishu.basic.equals;

/**
 * Created by Administrator on 2018/5/2.
 */
public class TestEquals {
    public static void main(String[] args) {
        Integer a = 127;
        Integer b = 127;
        Integer c = new Integer(127);

        if (a == c) {
            System.out.println("a == b");
        } else {
            System.out.println("a != b");
        }
    }
}
