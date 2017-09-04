package com.zhihuishu.thread.join_sleep;

/**
 * Created by Administrator on 2017/4/20.
 */
public class ThreadA extends Thread {
    private ThreadB b;
    public ThreadA(ThreadB b) {
        super();
        this.b = b;
    }

    @Override
    public void run() {
        try {
            synchronized (b) {
                b.start();
                Thread.sleep(6000); // 不释放锁
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
