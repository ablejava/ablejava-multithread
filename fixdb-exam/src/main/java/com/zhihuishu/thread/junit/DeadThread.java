package com.zhihuishu.thread.junit;

/**
 * Created by Administrator on 2017/4/6.
 * 多线程死锁问题
 */
class DealThread implements Runnable {

    public String username;
    public Object lock1 = new Object();
    public Object lock2 = new Object();
    public void setFlag(String username) {
        this.username = username;
    }

    @Override
    public void run() {
        if (username.equals("a")) {
            synchronized (lock1) {
                try {
                    System.out.println("username = " + username);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock2) {
                    System.out.println("按照lock1 --> lock2 代码顺序执行了");
                }
            }
        }

        if (username.equals("b")) {
            synchronized (lock2) {
                try {
                    System.out.println("username = " + username);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock1) {
                    System.out.println("按照lock2 --> lock1 代码顺序执行了");
                }
            }
        }

    }
}

class RunDealThread{
    public static void main(String[] args) {
        DealThread t1 = new DealThread();
        t1.setFlag("a");
        Thread thread1 = new Thread(t1);
        thread1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.setFlag("b");
        Thread thread2 = new Thread(t1);
        thread2.start();

    }

}
