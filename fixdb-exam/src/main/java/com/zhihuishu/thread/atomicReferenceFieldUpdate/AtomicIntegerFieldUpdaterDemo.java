package com.zhihuishu.thread.atomicReferenceFieldUpdate;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterDemo {

    public static class Candidate{
        int id;
        volatile int score;
    }

    public final static AtomicIntegerFieldUpdater<Candidate> scoreUpdate = AtomicIntegerFieldUpdater.newUpdater(Candidate.class, "score");

    public static AtomicInteger allScore = new AtomicInteger(0);

    /**
     * 注意：
     *      1.被update的字段不能申请为private类型
     *      2.被修改的字段需要使用validate修饰
     *      3.不支持修改static类型的变量
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        final Candidate stu = new Candidate();
        Thread[] t = new Thread[1000];
        for (int i = 0; i < 1000; i++) {
            t[i] = new Thread(){
                @Override
                public void run() {
                    if (Math.random() >0.4){
                        scoreUpdate.incrementAndGet(stu);
                        allScore.incrementAndGet();
                    }
                }
            };
            t[i].start();
        }

        for (int i = 0; i < 1000; i++) {
            t[i].join();
        }

        System.out.println("score:"+stu.score);
        System.out.println("allscore:"+allScore);

    }
}
