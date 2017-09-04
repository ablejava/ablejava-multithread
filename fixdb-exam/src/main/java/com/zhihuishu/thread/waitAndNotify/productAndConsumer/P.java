package com.zhihuishu.thread.waitAndNotify.productAndConsumer;

import com.zhihuishu.thread.waitAndNotify.*;

/**
 * Created by Administrator on 2017/4/15.
 */
public class P {
    private String lock;
    public P(String lock){
        super();
        this.lock = lock;
    }
    public void setValue() {
        try {
            synchronized (lock){
                if (!ValueObject.value.equals("")){
                    lock.wait();
                }
                String value = System.currentTimeMillis() + "_" +System.nanoTime();
                System.out.println("set的值是 =" + value);
                ValueObject.value = value;
                lock.notify();// 通知所有消费者
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
