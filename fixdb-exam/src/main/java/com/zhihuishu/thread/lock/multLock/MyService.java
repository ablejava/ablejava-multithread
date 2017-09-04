package com.zhihuishu.thread.lock.multLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/4/7.
 */
public class MyService {
    private Lock lock = new ReentrantLock();
    public Condition conditionA = lock.newCondition();
    public Condition conditionB = lock.newCondition();

    public void awaitA() {
        try {
            lock.lock();
            System.out.println("begin awaitA 时间为 = " + Thread.currentThread().getName() +" ThreadName =  " + Thread.currentThread().getName());
            conditionA.await();
            System.out.println("end awaitA 时间为 = " + Thread.currentThread().getName() +" ThreadName =  " + Thread.currentThread().getName());
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void awaitB() {
        try {
            lock.lock();
            System.out.println("begin awaitB 时间为 = " + Thread.currentThread().getName() +" ThreadName =  " + Thread.currentThread().getName());
            conditionB.await();
            System.out.println("end awaitB 时间为 = " + Thread.currentThread().getName() +" ThreadName =  " + Thread.currentThread().getName());
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void signalAll_A() {
        try {
            lock.lock();
            System.out.println("signalAll_A 时间为 = " + Thread.currentThread().getName() +" ThreadName =  " + Thread.currentThread().getName());
            conditionA.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void signalAll_B() {
        try {
            lock.lock();
            System.out.println("signalAll_B 时间为 = " + Thread.currentThread().getName() +" ThreadName =  " + Thread.currentThread().getName());
            conditionB.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
