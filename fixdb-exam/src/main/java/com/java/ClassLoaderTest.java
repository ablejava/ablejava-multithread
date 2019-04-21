package com.java;

import java.util.List;

public class ClassLoaderTest {

    static {
        System.out.println("test");
    }
    public static void main(String[] args) throws Exception{
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class<?> aClass = classLoader.loadClass("com.java.ClassLoaderTest");
        System.out.println("--------------------------------");
        aClass = Class.forName("com.java.ClassLoaderTest");
    }
}
