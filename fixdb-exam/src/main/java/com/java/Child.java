package com.java;

public class Child extends Base {
    int i =4;
    static {
        int j =7;
        System.out.println("Child j = " + j);
    }
    public Child(){
        super();
        print();
        i = i+4;
    }

    public void print() {
        System.out.println("Child i = " + i);
    }
}
