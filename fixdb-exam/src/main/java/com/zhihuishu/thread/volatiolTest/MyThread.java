package com.zhihuishu.thread.volatiolTest;

/**
 * Created by Administrator on 2017/5/4.
 */
public class MyThread extends Thread {
    volatile public static int count;

    // volatile主要使用的场合是多个线程总可以感知实例变量被更改了，并且可以获取最新的值的使用，也就是用多线程读取共享变量可以获取最新值的使用
    // 是count ++ 并不是原子性操作 所以所 volatile本身并不处理数据的原子性 可以使用AtomicInteger原子类来实现
    private static void addCount() {
        for (int i =0; i<100; i++) {
            count ++;
        }
        System.out.println("count = " + count);
    }

    @Override
    public void run() {
        addCount();
    }
}
