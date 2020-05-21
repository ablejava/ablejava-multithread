package com.java;

public class Child3 extends Parent3 {
    static {
        System.out.println("child static ...");
    }
}
class TestChild{
    public static void main(String[] args) {
        System.out.println(Child3.a);
    }
}
