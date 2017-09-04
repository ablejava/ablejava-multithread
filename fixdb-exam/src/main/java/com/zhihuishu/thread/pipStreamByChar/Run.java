package com.zhihuishu.thread.pipStreamByChar;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * Created by Administrator on 2017/4/15.
 */
public class Run {

    /**
     * 字符流的方式实现线程间的通信
     * @param args
     */
    public static void main(String[] args) {
        try {
            WriteData writeData = new WriteData();
            ReadDate readData = new ReadDate();

            PipedReader inputStream = new PipedReader();
            PipedWriter outputStream = new PipedWriter();

            // inputStream.connect(outputStream);
            outputStream.connect(inputStream);

            ThreadRead threadRead = new ThreadRead(readData, inputStream);
            threadRead.start();

            Thread.sleep(2000);
            ThreadWrite threadWrite = new ThreadWrite(writeData, outputStream);
            threadWrite.start();
        } catch (IOException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
