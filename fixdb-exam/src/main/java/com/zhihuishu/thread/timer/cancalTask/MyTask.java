package com.zhihuishu.thread.timer.cancalTask;

import java.util.TimerTask;

/**
 * Created by Administrator on 2017/4/27.
 */
public class MyTask extends TimerTask {
    @Override
    public void run() {
        // TimerTask 类中的cancal()方法的作用是将自身从任务队列中删除，
        this.cancel();
    }
}
