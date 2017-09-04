package com.zhihuishu.thread.pipStreamByChar;


import java.io.PipedInputStream;
import java.io.PipedReader;

/**
 * Created by Administrator on 2017/4/15.
 */
public class ThreadRead extends Thread {
    private ReadDate read;
    private PipedReader input;

    public ThreadRead(ReadDate read, PipedReader input) {
        super();
        this.read = read;
        this.input = input;
    }

    @Override
    public void run() {
        read.readMethod(input);
    }
}
