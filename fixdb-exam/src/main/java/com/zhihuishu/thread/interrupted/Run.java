package com.zhihuishu.thread.interrupted;

/**
 * Created by Administrator on 2017/5/2.
 */
public class Run {
    public static void main(String[] args)  {
        try {
            //
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(1000);
            // 下面两个的区别：
            thread.interrupt();
            // Thread.currentThread().interrupt();
            System.out.println(" 是否停止 1 ? = "+thread.interrupted());
            System.out.println(" 是否停止 2 ? = "+thread.interrupted());
            /*System.out.println(" 是否停止 1 ? = "+Thread.interrupted());
            System.out.println(" 是否停止 2 ? = "+Thread.interrupted());*/
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" end ");
    }
}
