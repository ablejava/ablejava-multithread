package com.zhihuishu.thread.suspendAndResume;

/**
 * suspend：线程的挂起
 * resume：继续执行
 * 不推荐使用suspend去挂起线程，是因为suspend()在导致线程暂停的同时，并不会去释放任何锁资源。导致其他线程无法正常执行，直到对应的线程进行了resume操作，被挂起的线程才能继续执行
 * 如果resume操作意外的suspend前就执行了，那么挂起的线程就可能很难有机会被继续执行，永久挂起
 * 使用wait和notify实现suspend和resume
 */
public class GoodSuspend {
    public static Object u = new Object();

    public static class ChangeObjectThread extends Thread {
        volatile boolean suspend = false;
        public void suspendMe() {
            suspend = true;
        }

        public void resumeMe() {
            suspend = false;
            synchronized (this) {
                notify();
            }
        }


        @Override
        public void run() {
            while (true) {
                synchronized (this) {
                    while (suspend) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

                synchronized (u) {
                    System.out.println(" in change Object Thread");
                }

                Thread.yield();

            }
        }
    }

    public static class ReadObjectThread extends Thread {

        @Override
        public void run() {
            while (true) {
                synchronized (u) {
                    System.out.println(" in read object thread");
                }

                Thread.yield();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException{
        ChangeObjectThread t1 = new ChangeObjectThread();
        ReadObjectThread t2 = new ReadObjectThread();
        t1.start();
        t2.start();
        Thread.sleep(1000);
        t1.suspendMe();
        System.out.println("suspend t1 2 sec");
        Thread.sleep(2000);
        System.out.println("resume t1");
        t1.resumeMe();
    }

}
