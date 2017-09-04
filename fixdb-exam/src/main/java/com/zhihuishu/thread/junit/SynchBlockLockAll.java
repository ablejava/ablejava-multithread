package com.zhihuishu.thread.junit;

/**
 * Created by Administrator on 2017/4/1.
 */
public class SynchBlockLockAll {
    public static void main(String[] args){
        // 结论1：当多个线程同时执行synch(x){}同步代码时呈现同步效果
        Service service = new Service();
        MyObject object = new MyObject();
        /*ThreadAA threadAA = new ThreadAA(service, object);
        threadAA.setName("A");
        threadAA.start();
        ThreadBB threadBB = new ThreadBB(service, object);
        threadBB.setName("b");
        threadBB.start();*/
        // 结论2：当其他线程执行x对象中synchronized同步方法时呈现同步
        /*ThreadAA threadAA = new ThreadAA(service, object);
        threadAA.setName("A");
        threadAA.start();
        ThreadBBB threadBBB = new ThreadBBB(object);
        threadBBB.setName("B");
        threadBBB.start();*/
        // 结论3：当其他线程执行x对象里面的synchronized(this)代码块也呈现同步效果
        ThreadAA threadAA = new ThreadAA(service, object);
        threadAA.setName("A");
        threadAA.start();
        ThreadBBBB threadBBBB = new ThreadBBBB(object);
        threadBBBB.setName("B");
        threadBBBB.start();

    }
}
class Service {
    public void testMethod1(MyObject object) {
        // 多个线程同时执行X对象中synch同步代码块，当监事对象 object是同一个对象呈现同步，当object不是同一个对象 呈现不同步
        synchronized (object) {
            try {
                System.out.println("testMethod1 ---- getLock time = " + System.currentTimeMillis() +" run ThreadName = "+ Thread.currentThread().getName());
                Thread.sleep(2000);
                System.out.println("testMethod1 ---- releaseLock time = " + System.currentTimeMillis() +" run ThreadName = "+ Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadAA extends Thread{
    private Service service;
    private MyObject object;

    public ThreadAA(Service service, MyObject object) {
        super();
        this.service = service;
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        service.testMethod1(object);
    }
}

class ThreadBB extends Thread{
    private Service service;
    private MyObject object;

    public ThreadBB(Service service, MyObject object) {
        super();
        this.service = service;
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        service.testMethod1(object);
    }
}

class ThreadBBB extends Thread {
    private MyObject object;

    public ThreadBBB(MyObject object) {
        super();
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        object.methodA();
    }
}

class ThreadBBBB extends Thread {
    private MyObject object;

    public ThreadBBBB(MyObject object) {
        super();
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        object.methodC();
    }
}