package com.zhihuishu.thread.reentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2018/7/8.
 */
public class TimeLock implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();


    @Override
    public void run() {
        try {
            // 表示线程在这个锁请求中，最长等待5m,如果超过5m还没有得到锁，就返回false,如果成功获得锁，返回true
            if (lock.tryLock(5, TimeUnit.SECONDS)) {
                Thread.sleep(6000);
            } else {
                System.out.println("get lock failed");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread())
                lock.unlock();
        }
    }
}
