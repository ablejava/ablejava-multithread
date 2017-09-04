package com.zhihuishu.thread.lock.lockSync;

/**
 * Created by Administrator on 2017/4/25.
 */
public class ThreadBB extends Thread{
    private MyService service;

    public ThreadBB(MyService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.methodB();
    }
}
