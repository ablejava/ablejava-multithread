package com.zhihuishu.thread.daemonThread;

/**
 * Created by Administrator on 2018/7/8.
 */
public class DaemonThread {

    public static class DaemonT extends Thread {
        @Override
        public void run() {

            while (true) {
                System.out.println(" i am alive");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 只有main线程，因此在线程休眠2s后退出，整个程序也就随之结束，如果不把线程t设置为守护线程，main线程结束后，t线程还会不停的打印。
     * main线程为用户线程，是系统的工作线程
     * daemon是守护线程，如果用户线程结束，那么守护线程也就要结束了。
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Thread t = new DaemonT();
        t.setDaemon(true);
        t.start();
        Thread.sleep(2000);
    }



}
