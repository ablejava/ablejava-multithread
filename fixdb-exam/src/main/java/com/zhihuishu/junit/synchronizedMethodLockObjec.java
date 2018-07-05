package com.zhihuishu.junit;

/**
 * Created by Administrator on 2017/3/31.
 */
public class synchronizedMethodLockObjec {
    public static void main(String[] args) {
        /**
         * A线程先持有object对象的Lock锁，B线程可以异步的方式调用object对象的非synchronized类型的方法
         * A线程先持有object对象的Lock锁，B线程如果在这时调用object对象的synchronized类型的方法则需要等待，也就是同步
         */
        MyObject myObject = new MyObject();
        ThreadA threadA = new ThreadA(myObject);
        threadA.setName("A");
        ThreadB threadB = new ThreadB(myObject);
        threadB.setName("B");
        threadA.start();
        threadB.start();
    }
}

class MyObject {
    synchronized public void methodA() {
        System.out.println("begin methodA threadName = " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
            System.out.println("end endTime = " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void methodB() {
        System.out.println("begin methodB threadName = " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
            System.out.println("end ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadA extends Thread {

    private MyObject myObject;
    public ThreadA(MyObject myObject) {
        super();
        this.myObject = myObject;
    }

    @Override
    public void run() {
        super.run();
        myObject.methodA();
    }
}

class ThreadB extends Thread {

    private MyObject myObject;
    public ThreadB(MyObject myObject) {
        super();
        this.myObject = myObject;
    }

    @Override
    public void run() {
        super.run();
        myObject.methodB();
    }
}