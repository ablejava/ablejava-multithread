package com.zhihuishu.thread.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2019/3/12.
 */
public class ReenterLockT implements Runnable{
    public static ReentrantLock lock = new ReentrantLock();
    public static int i =0;

    @Override
    public void run() {
        for (int j =0; j< 100000; j++) {
            lock.lock();
            try {
                i++;
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        ReenterLockT tl = new ReenterLockT();
        Thread t1 = new Thread(tl);
        Thread t2 = new Thread(tl);
        t1.start();t2.start();
        t1.join();t2.join();
        System.out.println("*****************"+i);
    }
}
