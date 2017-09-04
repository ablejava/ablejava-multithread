package com.zhihuishu.thread.timer.timeTask1;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * Created by Administrator on 2017/4/27.
 */
public class Run {
    public static void main(String[] args) {
        System.out.println("当前时间为：" + new Date());
        Calendar calendar = Calendar.getInstance();
        /**
         * 十秒后执行，虽然执行完了，但是线程还是没有停止，因为jdk源码可知道，
         * pubcli Timer(String name) {
         *  thread.setName(name);
         *  thread.start();
         * }
         * timer重新启动了一个线程，新启动的线程并不是守护线程，一直在运行
          */


        calendar.add(Calendar.SECOND, 10);
        Date runDate = calendar.getTime();
        MyTask myTask = new MyTask();
        Timer timer = new Timer();
        //改为守护线程 ***********
        //Timer timer = new Timer(true);
        timer.schedule(myTask, runDate);

    }
}
