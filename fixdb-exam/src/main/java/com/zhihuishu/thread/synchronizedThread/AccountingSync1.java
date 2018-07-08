package com.zhihuishu.thread.synchronizedThread;

/**
 * Created by Administrator on 2018/7/8.
 */
public class AccountingSync1 implements Runnable{

    static AccountingSync1 instance = new AccountingSync1();
    static  int i =0;


    @Override
    public void run() {
        for (int j = 0; j < 10000000; j++) {
            synchronized (instance) {
                i++;
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
