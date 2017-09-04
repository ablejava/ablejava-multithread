package com.zhihuishu.thread.reentrantReadWriteLock.ReadWriteLockBegin.WriteReadLockBegin;

/**
 * Created by Administrator on 2017/5/8.
 */
public class Run {
    public static void main(String[] args) {

        // 读写互斥
        Service service = new Service();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ThreadB b = new ThreadB(service);
        b.setName("B");
        a.start();
        b.start();
    }
}
