package com.zhihuishu.thread.threadGroupException.createThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by Administrator on 2020/5/21.
 */
public class CreateThread {
    static class MyThread extends Thread{

        @Override
        public void run() {
            System.out.println("hello myThread.....");
        }
    }

    static class MyRun implements Runnable{
        @Override
        public void run() {
            System.out.println("hello myRun....");
        }
    }

    static class MyCall implements Callable<String>{
        @Override
        public String call() throws Exception {
            System.out.println("hello myCall");
            return "success";
        }
    }

    public static void main(String[] args) {
        //第一种
        new MyThread().start();
         // 第二种
        new Thread(new MyRun()).start();
         // 第三种
        new Thread(() -> {
            System.out.println("hello lambda...");
        }).start();

        // 第四种
        Thread t = new Thread(new FutureTask<String>(new MyCall()));
        t.start();

        // 第五种
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(() -> {
            System.out.println("hello thrad pool...");
        });
        service.shutdown();
    }
}
