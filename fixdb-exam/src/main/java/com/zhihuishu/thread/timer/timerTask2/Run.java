package com.zhihuishu.thread.timer.timerTask2;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * Created by Administrator on 2017/4/27.
 */
public class Run {
    public static void main(String[] args){
        // 执行时间为延迟
        System.out.println("当前时间为 ：" + new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 10);
        Date runDate = calendar.getTime();
        System.out.println("计划之间为 ：" + runDate);
        MyTaskA taskA = new MyTaskA();
        Timer timer = new Timer();
        timer.schedule(taskA, runDate, 3000);
    }
}
