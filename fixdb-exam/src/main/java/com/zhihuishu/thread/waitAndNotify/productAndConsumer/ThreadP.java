package com.zhihuishu.thread.waitAndNotify.productAndConsumer;

/**
 * Created by Administrator on 2017/4/15.
 * 生产者线程
 */
public class ThreadP extends Thread{
    private P p;
    public ThreadP(P p) {
        super();
        this.p = p;
    }

    @Override
    public void run() {
        while (true){
            p.setValue();
        }
    }
}
