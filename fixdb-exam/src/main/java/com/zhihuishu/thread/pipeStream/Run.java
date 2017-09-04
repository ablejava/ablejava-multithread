package com.zhihuishu.thread.pipeStream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created by Administrator on 2017/4/15.
 */
public class Run {
    /**
     * 通过字节流的方式实习线程间的通信
     * @param args
     */
    public static void main(String[] args) {
        try {
            WriteData writeData = new WriteData();
            ReadDate readDate = new ReadDate();
            PipedInputStream inputStream = new PipedInputStream();
            PipedOutputStream outputStream = new PipedOutputStream();

            // 使两个线程间产生通信链接，这样才可以将数据进行输入和输出
            // inputStream.connect(outputStream); // 两个都可以
            outputStream.connect(inputStream);

            ThreadRead threadRead = new ThreadRead(readDate, inputStream);
            threadRead.start();
            Thread.sleep(2000);

            ThreadWrite threadWrite = new ThreadWrite(writeData, outputStream);
            threadWrite.start();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
