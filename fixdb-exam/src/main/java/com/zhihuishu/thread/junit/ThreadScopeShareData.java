package com.zhihuishu.thread.junit;

import java.util.Random;

/**
 * Created by Administrator on 2017/3/28.
 */
public class ThreadScopeShareData {

    private static int data = 0;
    private static ThreadLocal<MyThreadScopData> ThreadScopData = new ThreadLocal<MyThreadScopData>();
    private static ThreadLocal<Integer> X = new ThreadLocal<Integer>();
    public static void main(String[] args) {

        for (int i=0; i< 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + " has put data :" + data);
                   /* MyThreadScopData myThreadScopData = new MyThreadScopData();
                    myThreadScopData.setAge(data);
                    myThreadScopData.setName("name " + data);
                    ThreadScopData.set(myThreadScopData);*/
                    MyThreadScopData.getInstance().setName("name " + data);
                    MyThreadScopData.getInstance().setAge(data);
                    X.set(data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }


    static class A{
        public void get(){
            int data = X.get();
            System.out.println("A from :" + Thread.currentThread().getName() + " has get data :" + data);
            /*MyThreadScopData myData = ThreadScopData.get();
            System.out.println("A from :" + Thread.currentThread().getName() + " has get myData :" + myData + " , " +myData.getAge());*/
            MyThreadScopData myData = MyThreadScopData.getInstance();
            System.out.println("A from :" + Thread.currentThread().getName() + " has get myData :" + myData.getName() + " , " +myData.getAge());

        }

    }

    static class B{
        public void get() {
            int data = X.get();
            System.out.println("B from :" + Thread.currentThread().getName() + " has get data :" + data);
            MyThreadScopData myData = MyThreadScopData.getInstance();
            System.out.println("B from :" + Thread.currentThread().getName() + " has get myData :" + myData.getName() +" , " + myData.getAge());
        }

    }
}

class MyThreadScopData {

    private MyThreadScopData () {}
    // 饱汉模式
    public static /*synchronized*/ MyThreadScopData getInstance(){
        MyThreadScopData instance = map.get();
        if (instance == null) {
            instance = new MyThreadScopData();
            map.set(instance);
        }
        return instance;
    }
    // private static MyThreadScopData instance = null;
    private static ThreadLocal<MyThreadScopData> map = new ThreadLocal<MyThreadScopData>();
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}