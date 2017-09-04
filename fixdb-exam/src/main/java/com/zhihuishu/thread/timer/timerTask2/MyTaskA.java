package com.zhihuishu.thread.timer.timerTask2;

import java.util.Date;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/4/27.
 */
public class MyTaskA extends TimerTask {
    @Override
    public void run() {
        System.out.println("A begin timer  = " + new Date());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("A end timer  = " + new Date());
    }
}
