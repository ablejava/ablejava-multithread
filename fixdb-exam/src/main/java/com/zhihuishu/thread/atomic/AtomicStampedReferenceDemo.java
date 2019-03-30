package com.zhihuishu.thread.atomic;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Created by Administrator on 2019/3/30.
 */
public class AtomicStampedReferenceDemo {
    static AtomicStampedReference<Integer> money = new AtomicStampedReference<Integer>(19, 0);

    public static void main(String[] args) {
        // 模拟多个线程同时更新后台数据库，为用户充值
        final int timestamp = money.getStamp();
        for (int i =0; i <3; i++) {
            new Thread() {
                @Override
                public void run() {

                    while (true) {
                        while (true){
                            Integer m = money.getReference();
                            if (m < 20) {
                                if (money.compareAndSet(m, m+20, timestamp, timestamp +1)) {
                                    System.out.println("余额小于20元，充值成功，余额："+ money.getReference());
                                    break;
                                }
                            } else {
                                // 余额大于20无须充值
                                break;
                            }
                        }
                    }
                }
            }.start();
        }
         new Thread(){
             @Override
             public void run() {

                 for (int i = 0; i < 100; i++) {
                     while (true) {
                         int timestamp = money.getStamp();
                         Integer m = money.getReference();
                         if (m > 10) {
                             System.out.println("大于10元");
                             if (money.compareAndSet(m, m-10, timestamp, timestamp +1)) {
                                 System.out.println("成功消费10元，余额："+money.getReference());
                                 break;
                             }
                         } else {
                             System.out.println("没有足够金额");
                             break;
                         }
                     }
                     try {
                         Thread.sleep(100);
                     } catch (InterruptedException e) {

                     }
                 }
             }
         }.start();
    }
}
