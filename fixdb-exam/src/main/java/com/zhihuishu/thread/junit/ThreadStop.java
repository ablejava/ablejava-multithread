package com.zhihuishu.thread.junit;

/**
 * Created by Administrator on 2017/3/31.
 */
public class ThreadStop {
    public static void main(String[] args) {
        // 线程的终止
        MyThread myThread = new MyThread();
        myThread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myThread.interrupt();

    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        while (true) {
            if (this.isInterrupted()) { // 判断线程是否结束
                System.out.println("停止啦 ********** ");
                return;
            }
            System.out.println("timeer ********** " + System.currentTimeMillis());
        }
    }
}
