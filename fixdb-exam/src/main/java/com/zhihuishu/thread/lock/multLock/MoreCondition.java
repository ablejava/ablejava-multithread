package com.zhihuishu.thread.lock.multLock;

/**
 * Created by Administrator on 2017/4/7.
 */
public class MoreCondition {
    public static void main(String[] args){
        // 只有线程a被唤醒，可知道ReentrantLock对象可以唤醒指定种类的线程

        MyService service = new MyService();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.signalAll_A();
    }
}
