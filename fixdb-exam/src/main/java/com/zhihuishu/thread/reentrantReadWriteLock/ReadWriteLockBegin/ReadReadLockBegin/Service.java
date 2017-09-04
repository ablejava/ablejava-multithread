package com.zhihuishu.thread.reentrantReadWriteLock.ReadWriteLockBegin.ReadReadLockBegin;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Administrator on 2017/5/8.
 */
public class Service {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public void read() {
        try {
            try {
                lock.readLock().lock();
                System.out.println("获得读锁 "+Thread.currentThread().getName() +" " +System.currentTimeMillis());
                Thread.sleep(10000);
            } finally {
                lock.readLock().lock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
