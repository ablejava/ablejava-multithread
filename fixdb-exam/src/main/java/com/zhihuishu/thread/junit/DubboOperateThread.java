package com.zhihuishu.thread.junit;

/**
 * Created by Administrator on 2017/3/31.
 */
public class DubboOperateThread {
    public static void main(String[] args) {
        /**
         * 当存在子父类继承关系时，子类完全可以通过“可重入锁”调用父类的同步方法
         * “可重入锁”：自己可以再次获取自己内部的锁，方法
         */
        DubboMyThread dubboMyThread = new DubboMyThread();
        dubboMyThread.start();
    }
}

class DubboMyThread extends Thread {
    @Override
    public void run() {
        Sub sub = new Sub();
        sub.operateISubMethod();
    }
}

class Main {
    public int i = 10;
    synchronized public void operateIMainMethod() {
        try {
            i --;
            System.out.println("main print i = " + i);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Sub extends Main {
    synchronized public void operateISubMethod() {
        try {
            while (i >0) {
                i --;
                System.out.println("sub print i = " + i);
                Thread.sleep(100);
                this.operateIMainMethod();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}