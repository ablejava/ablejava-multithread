package com.java;

public class Simple {

    public static  final int i = 6/3;

    static {
        System.out.println("Final class int");
    }
}

class SimpleTest{
    public static void main(String[] args) {
        System.out.println(Simple.i);
    }

}
