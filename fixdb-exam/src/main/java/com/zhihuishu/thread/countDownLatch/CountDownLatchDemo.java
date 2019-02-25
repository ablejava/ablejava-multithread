package com.zhihuishu.thread.countDownLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 模拟火箭点火，所有自检完毕后才进行点火
 * Created by Administrator on 2019/2/24.
 */
public class CountDownLatchDemo implements Runnable {
    static final CountDownLatch end = new CountDownLatch(10);
    static final CountDownLatchDemo demo = new CountDownLatchDemo();

    @Override
    public void run() {

        // 模拟检查任务
        try {
            Thread.sleep(new Random().nextInt(10) *10000);
            System.out.print("check complete");
            end.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            exec.submit(demo);
        }
        // 等待检查
        end.await();
        System.out.print("fire!");
        exec.shutdown();
    }
}
