package com.zhihuishu.thread.junit;

/**
 * Created by Administrator on 2017/3/29.
 *
 *
 */
public class MultiThreadShareData {
    public static void main (String[] args) {
        final ShareData1 data1= new ShareData1();

        for (int i=0; i<1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    data1.decrement();
                }
            }).start();

        }
        for (int i=0; i<1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    data1.increment();
                }
            }).start();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("*****************shareData1结束****************");
        ShareData2 data2 = new ShareData2();
        new Thread(data2).start();
        new Thread(data2).start();

    }
}

/**
 * 简单线程间是数据共享，每个线程执行不同的代码，用不同的Runnable对象
 */
class ShareData1 {
        private int j =0;
        public  void increment() {
            j ++;
        }

        public  void decrement() {
            j --;
        }
}

/**
 * 简单线程间是数据共享，每个线程执行相同的代码，使用同一Runnable对象
 */
class ShareData2 implements Runnable{
        private int count =100;
        @Override
        public void run() {
            while (true) {
                count--;
            }
        }
}
