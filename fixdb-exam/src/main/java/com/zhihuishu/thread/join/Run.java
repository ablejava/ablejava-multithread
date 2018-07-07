package com.zhihuishu.thread.join;

/**
 * Created by Administrator on 2017/4/15.
 */
public class Run {
    public static void main(String[] args){
        try {
            MyThread threadTest = new MyThread();
            threadTest.start();
            /**
             * 方法join(long) 和sleep(long)的区别：
             * 方法join(long)的功能内部是使用wait(long)方法来实现的所以join(long)方法就有释放锁的特性，
             * 释放锁后其他线程就可以调用此线程中的其他同步方法了
             * Thread.sleetp(long)方法却不释放锁，
             */
            //threadTest.join();
            Thread.sleep(500);
            System.out.println("我想当 threadTest 对象执行完毕后，我再执行，我做到了 ！！！");
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }



}
