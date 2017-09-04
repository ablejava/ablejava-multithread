package com.zhihuishu.thread.exception;

/**
 * Created by Administrator on 2017/4/28.
 */
public class UncaughtException {

    public static void main(String[] args){
        final MyThread thread = new MyThread();
        thread.setName(" 线程 thread ");
        // 方法 setUncaughtException是给指定的线程对象设置的异常处理器，在Thread中还可以使用setDefaultUncaughtExceptionHandler()方法，对所有的线程对象设置异常处理器
        /*MyThread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(" 线程 ：" + thread.getName() + " 出了异常");
                e.printStackTrace();
            }
        });*/

        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(" 线程 ：" + thread.getName() + " 出了异常");
                e.printStackTrace();
            }
        });
        thread.start();
        MyThread thread1 = new MyThread();
        thread1.setName(" thread1 ");
        thread1.start();
    }
}
