package com.zhihuishu.thread.executeService;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2019/3/18.
 */
public class DivTask implements Runnable {
    int a,b;
    @Override
    public void run() {
        double re = a/b;
        System.out.println(re);
    }

    public DivTask(int a, int b) {
        this.a = a;
        this.b = b;
    }

    /**
     * 线程池会吃掉异常
     * @param args
     */
    public static void main(String[] args) {
        ThreadPoolExecutor pools = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 0L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        for (int i = 0; i < 5; i++) {
            pools.submit(new DivTask(100, i));
            // pools.execute(new DivTask(100, i));
        }
    }
}
