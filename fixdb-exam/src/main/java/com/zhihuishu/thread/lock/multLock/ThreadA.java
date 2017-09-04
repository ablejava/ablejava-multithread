package com.zhihuishu.thread.lock.multLock;

/**
 * Created by Administrator on 2017/4/7.
 */
public class ThreadA extends Thread{
    private MyService service;
    public ThreadA(MyService service){
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.awaitA();
    }
}
