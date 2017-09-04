package com.zhihuishu.thread.fairLockAndNotFairLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/5/8.
 */
public class Service {
    private ReentrantLock lock;

    public Service(boolean isFair) {
        lock = new ReentrantLock(isFair);
    }

    public void serviceMethod() {
        try {
            lock.lock();
            System.out.println("ThreadName = " + Thread.currentThread().getName() + " 获得锁定");
        } finally {
            lock.unlock();
        }
    }
}
