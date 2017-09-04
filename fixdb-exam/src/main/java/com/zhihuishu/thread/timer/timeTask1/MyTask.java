package com.zhihuishu.thread.timer.timeTask1;

import java.util.Date;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/4/27.
 */
public class MyTask extends TimerTask{
    @Override
    public void run() {
        System.out.println("任务执行了，时间为：" + new Date());
    }
}
