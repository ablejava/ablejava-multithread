package com.zhihuishu.thread.reentrantReadWriteLock.ReadWriteLockBegin.WriteWriteLockBegin;

/**
 * Created by Administrator on 2017/5/8.
 */
public class Run {
    public static void main(String[] args) {

        // 写写互斥
        Service service = new Service();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        ThreadB b = new ThreadB(service);
        b.setName("B");
        a.start();
        b.start();
    }
}
