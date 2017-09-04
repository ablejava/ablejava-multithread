package com.zhihuishu.thread.waitAndNotify.productAndConsumer.pAndcUserStack;

/**
 * Created by Administrator on 2017/4/15.
 */
public class C_Thread extends Thread {
    private C r;
    public C_Thread(C r){
        super();
        this.r = r;
    }

    @Override
    public void run() {
        while (true){
            r.popService();
        }
    }
}
