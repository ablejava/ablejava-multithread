package com.zhihuishu.thread.join_sleep;

/**
 * Created by Administrator on 2017/4/20.
 */
public class ThreadC extends Thread {
    private ThreadB threadB;
    public ThreadC(ThreadB threadB) {
        super();
        this.threadB = threadB;
    }

    @Override
    public void run() {
        threadB.bService();
    }
}
