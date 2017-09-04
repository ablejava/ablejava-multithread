package com.zhihuishu.thread.threadGroupException;

/**
 * Created by Administrator on 2017/4/28.
 */
public class Run {
    public static void main(String[] args) {
        // 要想打印“静态的异常处理”则必须在public void uncaughtExceptio(Thread a, Throwable e)方法中加上super.uncauthtException(t,e);
        MyThreadGroup threadGroup = new MyThreadGroup("我的线程组");
        MyThread myThread = new MyThread(threadGroup, "我的线程");
        // 对象
        myThread.setUncaughtExceptionHandler(new ObjectUncaughtExceptionHandler());
        // 类
        MyThread.setDefaultUncaughtExceptionHandler(new StateUncaughtExceptionHandler());
    }
}
