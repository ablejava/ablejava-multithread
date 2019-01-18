package com.java;

public class Base {
    int i =3;
    static {
        int j = 4;
        System.out.println("Base j = " + j);
    }
    public Base(){
        print();
        i = i+3;
    }
    public void print() {
        System.out.println("Base i = " + i);
    }
}
