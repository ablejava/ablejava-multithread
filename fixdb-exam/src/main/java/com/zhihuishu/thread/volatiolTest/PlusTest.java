package com.zhihuishu.thread.volatiolTest;

/**
 * Created by Administrator on 2018/7/8.
 */
public class PlusTest {

    static volatile int i = 0;

    public static class PlusTask implements Runnable {
        @Override
        public void run() {
            for (int k = 0; k < 10000; k++) {
                k++;
            }
        }
    }
    public static void main(String[] args) throws InterruptedException{
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new PlusTask());
            threads[i].start();
        }
        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }
        System.out.println(i);
    }
}
