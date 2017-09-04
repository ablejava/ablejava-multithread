package com.zhihuishu.thread.threadGroupException;

/**
 * Created by Administrator on 2017/4/28.
 */
public class StateUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(" 静态的异常处理 ");
        e.printStackTrace();
    }
}
