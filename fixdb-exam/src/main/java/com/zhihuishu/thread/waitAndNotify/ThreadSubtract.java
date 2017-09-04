package com.zhihuishu.thread.waitAndNotify;

/**
 * Created by Administrator on 2017/4/15.
 */
public class ThreadSubtract extends Thread {
    private Subtract r;
    public ThreadSubtract(Subtract r) {
        super();
        this.r = r;
    }

    @Override
    public void run() {
        r.subtract();
    }
}
