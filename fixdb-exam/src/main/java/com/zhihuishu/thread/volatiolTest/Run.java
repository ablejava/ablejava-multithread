package com.zhihuishu.thread.volatiolTest;

/**
 * Created by Administrator on 2017/5/4.
 */
public class Run {
    public static void main(String[] args) {
        MyThread[] myThreadArray = new MyThread[100];
        for (int i=0; i<100; i++) {
            myThreadArray[i] = new MyThread();
        }
        for (int i=0; i<100; i++) {
            myThreadArray[i].start();
        }
    }
}
