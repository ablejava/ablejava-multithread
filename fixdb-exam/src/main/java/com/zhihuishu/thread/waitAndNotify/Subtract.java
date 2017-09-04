package com.zhihuishu.thread.waitAndNotify;

/**
 * Created by Administrator on 2017/4/15.
 */
public class Subtract {
    private String lock;
    public Subtract(String lock) {
        super();
        this.lock = lock;
    }
    public void subtract() {
        try {
            synchronized (lock){
                // while是循环语句，只有条件是false才会跳出，if 是判断语句只会执行一次
                // 如果判断为if就会出异常
                while (ValueObject.list.size() == 0){
                    System.out.println("wait begin ThreadName = " + Thread.currentThread().getName());
                    lock.wait();
                    System.out.println("wait end ThreadName = " + Thread.currentThread().getName());
                }
                ValueObject.list.remove(0);
                System.out.println(" list size = " + ValueObject.list.size());
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
