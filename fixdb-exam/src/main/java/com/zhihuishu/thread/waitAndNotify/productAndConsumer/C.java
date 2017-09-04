package com.zhihuishu.thread.waitAndNotify.productAndConsumer;

/**
 * Created by Administrator on 2017/4/15.
 * 消费者的类
 */
public class C {
    private String lock;
    public C(String lock){
        super();
        this.lock = lock;
    }
    public void getValue() {
        try {
            synchronized (lock){
                if (ValueObject.value.equals("")){
                    lock.wait();
                }
                System.out.println("get 的值是 " + ValueObject.value);
                ValueObject.value = "";
                lock.notify();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
