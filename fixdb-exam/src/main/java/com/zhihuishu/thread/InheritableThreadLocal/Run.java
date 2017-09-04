package com.zhihuishu.thread.InheritableThreadLocal;

/**
 * Created by Administrator on 2017/4/20.
 */
public class Run {
    public static void main(String[] args) {
        try {
            // 需要注意的是如果子线程在取值，主线程将InheritableThreadLocal中值进行改变，那么子线程取到的还是原来的旧值；
            for(int i=0; i < 10; i++) {
                System.out.println(" 在 main 线程中取值 =" + Tools.t1.get());
                Thread.sleep(100);
            }
            Thread.sleep(5000);
            ThreadA a = new ThreadA();
            a.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
