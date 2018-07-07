package com.zhihuishu.thread.waitAndNotify.simpleWN;

/**
 * 线程T1在执行wait前，必须获取obj的监视器
 * 线程T2在notify调用前，必须获取obj的监视器，此时T1已经释放了obj的监视器
 * 线程T1在重新执行前，也必须重新获取obj的监视器，
 */
public class SimpleWN {

    final static Object obj = new Object();
    public static class T1 extends Thread{
        public void run() {
            synchronized (obj) {
                System.out.println(System.currentTimeMillis()+"T1 start");
                try {
                    System.out.println(System.currentTimeMillis()+"T1 wait for obj");
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis()+"T1 end ");
            }
        }
    }

    public static class T2 extends Thread{

        @Override
        public void run() {
            synchronized (obj) {
                System.out.println(System.currentTimeMillis()+"T2 start notify one thread");
                obj.notify();
                System.out.println(System.currentTimeMillis()+"T2 end");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
            }

        }
    }


    public static void main(String[] args) {
        Thread thread1 = new T1();
        Thread thread2 = new T2();
        thread1.start();
        thread2.start();
    }
}
