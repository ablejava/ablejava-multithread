package com.zhihuishu.thread.reentrantReadWriteLock.ReadWriteLockBegin.WriteWriteLockBegin;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Administrator on 2017/5/8.
 */
public class Service {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public void write() {
        try {
            try {
                lock.writeLock().lock();
                System.out.print(" 获得写锁 " +Thread.currentThread().getName() + " " +System.currentTimeMillis());
                Thread.sleep(100);
            } finally {
                lock.writeLock().unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
