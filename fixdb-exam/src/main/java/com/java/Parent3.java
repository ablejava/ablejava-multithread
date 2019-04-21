package com.java;

public class Parent3 {
    static int a = 3;
    static {
        System.out.println("parent3 static ");
    }

    public static void doSomething() {
        System.out.println("doSomething...");
    }
}
