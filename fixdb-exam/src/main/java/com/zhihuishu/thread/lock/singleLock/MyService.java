package com.zhihuishu.thread.lock.singleLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/4/7.
 */
public class MyService {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void testMethod() {
        lock.lock();
        for (int i=0; i<5; i++) {
            System.out.println("ThreadName = " + Thread.currentThread().getName() +" "+(i+1));
        }
        lock.unlock();
    }

    public void await() {
        try {
            lock.lock();
            System.out.println("await 时间为 ******" + System.currentTimeMillis());
            condition.await();
            System.out.println("b******");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println("锁释放了******");
        }
    }

    public void signal() {
        try {
            lock.lock();
            System.out.println("signal 时间为 ******" + System.currentTimeMillis());
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
}

class MyThread extends Thread{
    private MyService service;
    public MyThread(MyService service){
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}



class ThreadA extends Thread{
    private MyService service;
    public ThreadA(MyService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.await();
    }
}

class Run{
    public static void main(String[] args) {
        MyService service = new MyService();
        /*MyThread a1= new MyThread(service);
        MyThread a2 = new MyThread(service);
        MyThread a3 = new MyThread(service);
        MyThread a4 = new MyThread(service);
        MyThread a5 = new MyThread(service);
        a1.start();
        a2.start();
        a3.start();
        a4.start();
        a5.start();*/

        ThreadA threadA = new ThreadA(service);
        threadA.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.signal();
    }
}