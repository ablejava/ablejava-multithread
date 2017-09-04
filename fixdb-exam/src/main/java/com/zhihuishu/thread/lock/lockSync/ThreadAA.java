package com.zhihuishu.thread.lock.lockSync;

/**
 * Created by Administrator on 2017/4/25.
 */
public class ThreadAA extends Thread {
    private MyService service;

    public ThreadAA(MyService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.methodA();
    }
}
