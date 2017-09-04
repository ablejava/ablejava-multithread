package com.zhihuishu.thread.lock.conditionTestManyToMany;

/**
 * Created by Administrator on 2017/4/26.
 */
public class MyThreadA extends Thread {
    private MyService service;
    public MyThreadA(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            service.set();
        }
    }
}
