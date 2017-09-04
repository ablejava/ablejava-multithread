package com.zhihuishu.thread.lock.conditionTestManyToMany;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/4/26.
 */
public class MyService {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean hasValue = false;
    public void set() {
        try {
            lock.lock();
            while (hasValue == true) {
                System.out.println("有可能 ❤❤ 连续");
                condition.await();
            }
            System.out.println("打印 ❤");
            hasValue = true;
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void get() {
        try {
            lock.lock();
            while (hasValue == false) {
                System.out.println("有可能 ☆☆ 连续");
                condition.await();
            }
            System.out.println("打印 ☆");
            hasValue = false;
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
