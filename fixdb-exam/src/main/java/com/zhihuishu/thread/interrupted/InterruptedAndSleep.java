package com.zhihuishu.thread.interrupted;

/**
 * Created by Administrator on 2018/7/7.
 */
public class InterruptedAndSleep {

    /**
     * 当在sleep中的线程被调用interrupt方法时，就会放弃暂停的状态，并抛出InterruptException异常，这样一来，线程的控制权就交给了捕获这个异常的catch块了
     * @param args
     * @throws InterruptedException
     */
    public static void main (String[] args) throws InterruptedException{
        Thread thread = new Thread(){
            @Override
            public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("interrupted...");
                        break;
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println("interrupted when sleep");
                        // 设置中断状态
                        Thread.currentThread().interrupt();
                    }
                    Thread.yield();
                }
                System.out.println("111");
            }
        };
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }
}
