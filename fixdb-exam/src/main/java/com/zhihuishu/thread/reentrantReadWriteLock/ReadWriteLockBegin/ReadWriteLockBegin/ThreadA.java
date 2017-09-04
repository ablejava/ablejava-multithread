package com.zhihuishu.thread.reentrantReadWriteLock.ReadWriteLockBegin.ReadWriteLockBegin;

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
        service.read();
    }
}
