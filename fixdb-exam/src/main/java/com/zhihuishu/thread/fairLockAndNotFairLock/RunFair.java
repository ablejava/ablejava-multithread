package com.zhihuishu.thread.fairLockAndNotFairLock;

/**
 * Created by Administrator on 2017/5/8.
 */
public class RunFair {
    public static void main(String[] args) {
        // 公平锁 标识线程获取锁的顺序是按照线程加锁的顺序来执行的 即先来先得锁
        final Service service = new Service(true);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("☆ 线程"+Thread.currentThread().getName() + "运行了");
                service.serviceMethod();
            }
        };
        Thread[] threadArray = new Thread[10];
        for (int i =0; i<10;i++) {
            threadArray[i] = new Thread(runnable);
        }
        for (int i=0; i<10; i++) {
            threadArray[i].start();
        }

    }
}
