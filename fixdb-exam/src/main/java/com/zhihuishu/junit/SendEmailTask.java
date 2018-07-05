package com.zhihuishu.junit;

import java.util.concurrent.Callable;

/**
 * Created by Administrator on 2017/3/28.
 */
public class SendEmailTask implements Callable<Boolean> {

    @Override
    public Boolean call() throws Exception {
        // 模拟发送
        Thread.sleep(2000);
        if (Math.random() * 0.5 > 0.2) {
            return false;
        }
        return true;
    }
}
