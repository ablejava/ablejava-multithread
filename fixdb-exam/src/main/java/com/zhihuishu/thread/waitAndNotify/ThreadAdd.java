package com.zhihuishu.thread.waitAndNotify;

/**
 * Created by Administrator on 2017/4/15.
 */
public class ThreadAdd extends Thread {
    private Add p;
    public ThreadAdd(Add p){
        super();
        this.p = p;
    }

    @Override
    public void run() {
        p.add();
    }
}
