package com.java;

import java.util.Random;

public class SimpleRandom {
    public static  final int i=new Random().nextInt(100) ;

    static {
        System.out.println("Final class int");
    }
}

class SimpleRandomTest{
    public static void main(String[] args) {
        System.out.println(SimpleRandom.i);
    }

}
