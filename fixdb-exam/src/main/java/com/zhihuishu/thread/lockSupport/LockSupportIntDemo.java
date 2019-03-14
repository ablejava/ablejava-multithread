package com.zhihuishu.thread.lockSupport;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by Administrator on 2019/2/24.
 * 线程阻塞工具
 * 使用类似信号量的机制，每个线程只有一个许可，如果许可可用那么park()函数就会立即返回，并且消费这个许可，
 * 如果许可不可用，就会阻塞，而unpark()则使得一个许可变为可用，
 */
public class LockSupportIntDemo {
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
                if (Thread.interrupted()) {
                    System.out.println(getName() +"被中断了");
                }
            }
            System.out.println(getName()+"执行结束");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(100);
        t2.start();
        t1.interrupt();
        LockSupport.unpark(t2);
    }
}
