package com.zhihuishu.thread.future;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {


    public static Integer calc(Integer para) {
        try {
            //模拟一个长时间的执行
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        return para * para;
    }


    /**
     * supplyAsync返回一个新的线程
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws  Exception{
        final CompletableFuture<Object> future = CompletableFuture.supplyAsync(() -> calc(50));
        System.out.println(future.get());
    }
}
