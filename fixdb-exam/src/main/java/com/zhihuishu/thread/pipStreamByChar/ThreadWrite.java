package com.zhihuishu.thread.pipStreamByChar;


import java.io.PipedOutputStream;
import java.io.PipedWriter;

/**
 * Created by Administrator on 2017/4/15.
 */
public class ThreadWrite extends Thread {
    private WriteData write;
    private PipedWriter out;

    public ThreadWrite(WriteData write, PipedWriter out) {
        super();
        this.write = write;
        this.out = out;
    }

    @Override
    public void run() {
        write.writeMethod(out);
    }
}
