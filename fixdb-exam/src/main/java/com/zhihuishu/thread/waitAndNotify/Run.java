package com.zhihuishu.thread.waitAndNotify;

/**
 * Created by Administrator on 2017/4/12.
 */
public class Run {
    public static void main(String[] args){

        Object lock = new Object();
        ThreadA A = new ThreadA(lock);
        A.start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ThreadB B = new ThreadB(lock);
        B.start();
        /**
         *
         wait begin 1491995215912
         添加了 1个元素
         添加了 2个元素
         添加了 3个元素
         添加了 4个元素
         已发出通知
         添加了 5个元素
         添加了 6个元素
         添加了 7个元素
         添加了 8个元素
         添加了 9个元素
         添加了 10个元素
         wait end 1491995225961
         */
        /**
         * 只执行了notify后，当前线程不会立即释放资源，执行完所在的同步synchronized代码块后才释放资源
         2、在执行同步代码块过程中出现异常会导致线程终止，会释放锁。
         3、只执行同步代码块过程中，执行了锁所属对象的wait()方法，这个线程会释放对象锁，而此线程对象会进入线程等待池中，等待被唤醒。

         */

    }
}
