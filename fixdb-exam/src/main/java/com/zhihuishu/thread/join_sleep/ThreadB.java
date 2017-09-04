package com.zhihuishu.thread.join_sleep;

/**
 * Created by Administrator on 2017/4/20.
 */
public class ThreadB extends Thread {

    @Override
    public void run() {
        try {
            System.out.println(" b run begin timer = " + System.currentTimeMillis());
            //Thread.sleep(5000);
            System.out.println(" b run end timer = " + System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    synchronized  public void bService() {
        System.out.println(" 打印了 bService  timer = " + System.currentTimeMillis());
    }
}
