package com.zhihuishu.thread.timer.cancalTaskFailed;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * Created by Administrator on 2017/4/27.
 */
public class Test {
    public static void main(String[] args) throws InterruptedException{
        int i =0;
        Calendar calendar = Calendar.getInstance();
        Date runDate = calendar.getTime();
        // 任务没有停止，原因是Timer类中的cancal()方法有事没有抢到queue锁， 则让TimerTask类中的任务正常执行
        while (true){
            i++;
            Timer timer = new Timer();
            MyTaskA taskA = new MyTaskA(i);
            timer.schedule(taskA, runDate);
            timer.cancel();
        }


    }
}
