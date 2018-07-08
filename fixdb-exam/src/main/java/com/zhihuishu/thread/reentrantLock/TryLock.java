package com.zhihuishu.thread.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2018/7/8.
 */
public class TryLock implements Runnable {
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int lock;

    public TryLock(int lock) {
        this.lock = lock;
    }

    /**
     *
     * ReentrantLock.tryLock()，当前线程会尝试获得锁，如果锁并没有被其他线程占用，则申请成功，并返回true
     * 如果锁被其他线程占用，当前线程不会等待，而是立即返回false，这种模式先不会引起线程等待，也就不会参数死锁。
     *
     *
     */
    @Override
    public void run() {
        if (lock ==1) {
            while (true){
                if (lock1.tryLock()){
                    try {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (lock2.tryLock()){
                            try {
                                System.out.println(Thread.currentThread().getId()+"my job done");
                                return;
                            } finally {
                                lock2.unlock();
                            }
                        }

                    } finally {
                        lock1.unlock();
                    }
                }
            }
        } else {
            while (true) {
                if (lock2.tryLock()){
                    try {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        if (lock1.tryLock()){
                            try {
                                System.out.println(Thread.currentThread().getId()+" my job done");
                                return;
                            } finally {
                                lock1.unlock();
                            }
                        }
                    }finally {
                        lock2.unlock();
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        TryLock r1 = new TryLock(1);
        TryLock r2 = new TryLock(2);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();

    }

}
