package com.zhihuishu.thread.singletonModel;

/**
 * Created by Administrator on 2017/4/28.
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(MyObject.getInstance().hashCode());
    }
}
