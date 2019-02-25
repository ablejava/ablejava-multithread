package com.zhihuishu.thread.lockSupport;

import com.zhihuishu.thread.suspendAndResume.GoodSuspend;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by Administrator on 2019/2/24.
 * 线程阻塞工具
 * 使用类似信号量的机制，每个线程只有一个许可，如果许可可用那么park()函数就会立即返回，并且消费这个许可，
 * 如果许可不可用，就会阻塞，而unpark()则使得一个许可变为可用，
 */
public class LockSupportDemo {
    public static Object u = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread{
        public ChangeObjectThread(String name) {
            super.setName(name);
        }

        @Override
        public void run() {
            synchronized (u) {
                System.out.println("in "+ getName());
                LockSupport.park();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(100);
        t2.start();
        LockSupport.unpark(t1);
        LockSupport.unpark(t2);
        t1.join();
        t2.join();
    }
}
