package com.zhihuishu.thread.join;

/**
 * Created by Administrator on 2017/4/15.
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        try {
            int secondValue = (int) (Math.random() * 1000);
            System.out.println(secondValue);
            Thread.sleep(secondValue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
