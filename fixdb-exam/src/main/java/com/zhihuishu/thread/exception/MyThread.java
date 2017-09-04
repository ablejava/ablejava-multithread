package com.zhihuishu.thread.exception;

/**
 * Created by Administrator on 2017/4/28.
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        String username = null;
        System.out.println(username.hashCode());
    }
}
