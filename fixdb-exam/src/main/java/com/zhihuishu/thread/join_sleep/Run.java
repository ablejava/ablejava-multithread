package com.zhihuishu.thread.join_sleep;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Created by Administrator on 2017/4/20.
 */
public class Run {
    public static void main(String[] args) {
        try{
            // 由于线程a 使用Thread.sleep()一直持有线程ThreadB的对象锁，所以到达6s后才能执行ThreadB中的synchronized方法
            ThreadB b = new ThreadB();
            ThreadA a = new ThreadA(b);
            a.start();
            Thread.sleep(1000);
            ThreadC c = new ThreadC(b);
            c.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
