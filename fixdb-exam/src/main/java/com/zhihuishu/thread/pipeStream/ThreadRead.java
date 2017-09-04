package com.zhihuishu.thread.pipeStream;

import java.io.PipedInputStream;

/**
 * Created by Administrator on 2017/4/15.
 */
public class ThreadRead extends Thread {
    private ReadDate read;
    private PipedInputStream input;

    public ThreadRead(ReadDate read, PipedInputStream input) {
        super();
        this.read = read;
        this.input = input;
    }

    @Override
    public void run() {
        read.readMethod(input);
    }
}
