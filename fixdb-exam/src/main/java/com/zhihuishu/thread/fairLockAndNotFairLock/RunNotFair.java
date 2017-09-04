package com.zhihuishu.thread.fairLockAndNotFairLock;

/**
 * Created by Administrator on 2017/5/8.
 */
public class RunNotFair {
    public static void main(String[] args) {
        // 非公平锁是一种抢占机制，是随机获取锁，运行结果基本上是乱序的，说明start启动的线程不代表先获得锁
        final Service service = new Service(false);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("☆ 线程" + Thread.currentThread().getName() + " 运行了");
                service.serviceMethod();
            }
        };
        Thread[] threadArray = new Thread[10];
        for (int i=0; i<10; i++) {
            threadArray[i] = new Thread(runnable);
        }
        for (int i=0; i<10; i++){
            threadArray[i].start();
        }
    }
}
