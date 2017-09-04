package com.zhihuishu.thread.singletonModel;

/**
 * Created by Administrator on 2017/4/28.
 */
public class Run {

    // 使用DCL 双检测锁机制来实现多线程环境中的延迟加载代理模式，DCL模式也是大多数多线程环境下结合单例模式使用的解决方案

    // 使用静态内部类也可以实现
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        MyThread thread3 = new MyThread();
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
