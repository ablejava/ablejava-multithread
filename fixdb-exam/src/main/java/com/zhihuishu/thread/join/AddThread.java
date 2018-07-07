package com.zhihuishu.thread.join;

/**
 * Created by Administrator on 2018/7/7.
 */
public class AddThread extends Thread{

    public volatile static int i =0;

    @Override
    public void run() {
        for (i =0; i< 1000000; i++);
    }


    /**
     * 主线程会等待子线程执行的结果
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException{
        AddThread at = new AddThread();
        at.start();
        at.join();
        System.out.println(i);
    }

}
