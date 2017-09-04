package com.zhihuishu.thread.reentrantReadWriteLock.ReadWriteLockBegin.WriteReadLockBegin;

/**
 * Created by Administrator on 2017/5/8.
 */
public class ThreadB extends Thread {
    private Service service;

    public ThreadB(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.write();
    }
}
