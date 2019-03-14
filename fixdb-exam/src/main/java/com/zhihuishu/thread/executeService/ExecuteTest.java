package com.zhihuishu.thread.executeService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2019/3/12.
 */
public class ExecuteTest {
    public static void main(String[] args) throws InterruptedException{
        ExecutorService execute = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>());
        execute.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("run.....");
            }
        });

        execute.execute(new Run1());
    }



    private static class Run1 implements Runnable{

        @Override
        public void run() {
            int count =0;
            while (true) {
                count ++;
                System.out.println(".........22............");
                if (count == 10) {
                    try {

                        System.out.println(1/0);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                if (count == 20) {
                    System.out.println("count"+count);
                    break;
                }
            }
        }
    }

}
