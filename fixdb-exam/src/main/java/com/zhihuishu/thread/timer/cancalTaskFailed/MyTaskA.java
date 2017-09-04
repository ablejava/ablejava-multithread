package com.zhihuishu.thread.timer.cancalTaskFailed;

import java.util.TimerTask;

/**
 * Created by Administrator on 2017/4/27.
 */
public class MyTaskA extends TimerTask {
    private int i;

    public MyTaskA(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println("第" +i + "次没有被 cancal取消");
    }
}
