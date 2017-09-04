package com.zhihuishu.thread.reentrantReadWriteLock.ReadWriteLockBegin.ReadReadLockBegin;

/**
 * Created by Administrator on 2017/5/8.
 */
public class Run {
    public static void main(String[] args) {
        // 读读共享

        // 从控制台打印的结果来看 两个线程几乎同时进入lock()方法后面的代码，说明在此执行了lock.readLock()读锁可以提高程序的运行效率，运行多个线程同时执行lock()方法后面的代码
        Service service = new Service();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        ThreadB b = new ThreadB(service);
        b.setName("B");
        a.start();
        b.start();


    }
}
