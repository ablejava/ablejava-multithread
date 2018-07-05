package com.zhihuishu.junit;

/**
 * Created by Administrator on 2017/3/31.
 *
 */
class Run {
    public static void main(String[] args) {
        CountOperate countOperate = new CountOperate();
        Thread thread = new Thread(countOperate);
        thread.setName("A");
        thread.start();
    }
}

public class CountOperate extends Thread {
    public CountOperate() {
        System.out.println("CountOperate --- begin");
        /**
         *  Thread.currentThread.getName(); 和 this的区别
         *  this 指代当前CountOperate的类对象
          */
        System.out.println("Thread.currentThread().getName() == " + Thread.currentThread().getName());
        System.out.println("this.getName()== " + this.getName());
        System.out.println("CountOperate --- end");
    }

    @Override
    public void run() {
        System.out.println("run --- begin");
        System.out.println("Thread.currentThread().getName() == " + Thread.currentThread().getName());
        System.out.println("this.getName()== " + this.getName());
        System.out.println("run --- end");
    }
}
