package com.zhihuishu.thread.synchronizedThread;

/**
 * Created by Administrator on 2018/7/8.
 */
public class AccountingSync3 implements Runnable {
    static AccountingSync3 instance = new AccountingSync3();
    static int i =0;

    /**
     * 当线程实例不同时，同步代码块为静态方法，锁为当前对象实例
     */
    public static synchronized void increase() {
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 10000000; j++) {
            increase();
        }
    }


    /**
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new AccountingSync3());
        Thread t2 = new Thread(new AccountingSync3());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
