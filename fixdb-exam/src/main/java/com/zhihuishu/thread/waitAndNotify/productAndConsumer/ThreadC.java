package com.zhihuishu.thread.waitAndNotify.productAndConsumer;

/**
 * Created by Administrator on 2017/4/15.
 * 消费者线程
 */
public class ThreadC extends Thread {
    private C r;
    public ThreadC(C r) {
        super();
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            r.getValue();
        }
    }
}
