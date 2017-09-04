package com.zhihuishu.thread.waitAndNotify;

/**
 * Created by Administrator on 2017/4/12.
 */
public class Add {
    private String lock;
    public Add(String lock){
        super();
        this.lock = lock;
    }

    public void add() {
        synchronized (lock){
            ValueObject.list.add("anyString");
            lock.notifyAll();// 通知所有
        }
    }
}
