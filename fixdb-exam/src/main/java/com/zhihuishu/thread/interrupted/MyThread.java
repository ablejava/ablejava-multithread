package com.zhihuishu.thread.interrupted;

/**
 * Created by Administrator on 2017/5/2.
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i<50000; i++){
            System.out.println("i = " +(i+1));
        }
    }
}
