package com.zhihuishu.junit;

/**
 * Created by Administrator on 2017/3/29.
 *
 *
 */
public class MultiThreadShareData {
    public static void main (String[] args) {
        final ShareData1 data1= new ShareData1();
        new Thread(new Runnable() {
            @Override
            public void run() {
                data1.decrement();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                data1.increment();
            }
        }).start();
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
        public synchronized void increment() {
            j ++;
        }

        public synchronized void decrement() {
            j --;
        }
}

/**
 * 简单线程间是数据共享，每个线程执行相同的代码，使用同一Runnable对象
 */
class ShareData2 implements Runnable {
        private int count =100;
        @Override
        public void run() {
            while (true) {
                count--;
            }
        }
}
