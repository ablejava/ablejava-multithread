package com.zhihuishu.thread.junit;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/3/28.
 * 创建线程池，执行带返回值类型
 */
public class SendEmailTest {
    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(30, 30, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
        List<Future<Boolean>> futures = new ArrayList<Future<Boolean>>(1000);
        for (int i = 0; i<500; i++) {
            futures.add(poolExecutor.submit(new SendEmailTask()));
        }
        System.out.println("shutdown********");
        //启动一个关闭命令，不再接受新任务，当所有已提交任务执行完后，就关闭
        poolExecutor.shutdown();
        while (!poolExecutor.isTerminated()) { // 关闭后所有任务都已完成，则返回 true。
            poolExecutor.awaitTermination(1, TimeUnit.SECONDS);
            System.out.println("已经完成************"+poolExecutor.getCompletedTaskCount());
        }
        int error = 0;
        int success = 0;
        for (Future<Boolean> future : futures) {

            if (future.get() == true) {

                success ++;
            } else {
                error ++;
            }
        }

        System.out.println("已经发送成功"+success+"************失败"+error);
    }
}
