package com.zhihuishu.thread.timer.schedule;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/4/28.
 */
public class MyTask extends TimerTask {
    @Override
    public void run() {
        System.out.println(" begin timer = " + new Date());
        System.out.println(" end timer = " + new Date());
    }
    public static void main(String[] args) {
        MyTask task = new MyTask();
        // schedule方法不具有追赶执行性， scheduleAtFixedRate()方法具有追赶执行性

        System.out.println("现在执行时间 " + new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND), -20);
        Date runDate = calendar.getTime();
        System.out.println(" 计划执行时间 " + new Date());
        Timer timer = new Timer();
        timer.schedule(task, runDate, 2000);

    }
}
