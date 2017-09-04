package com.zhihuishu.thread.reentrantReadWriteLock.ReadWriteLockBegin.WriteWriteLockBegin;

/**
 * Created by Administrator on 2017/5/8.
 */
public class ThreadA extends Thread{
    private Service service;

    public ThreadA(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.write();
    }
}
