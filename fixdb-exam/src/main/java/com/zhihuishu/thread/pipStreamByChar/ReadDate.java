package com.zhihuishu.thread.pipStreamByChar;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedReader;

/**
 * Created by Administrator on 2017/4/15.
 */
public class ReadDate {

    public void readMethod(PipedReader inpue) {
        try {
            System.out.println("read :");
            char[] byteArray = new char[20];
            int readLength = inpue.read(byteArray);
            while (readLength != -1){
                String newData = new String(byteArray, 0, readLength);
                System.out.print(newData);
                readLength = inpue.read(byteArray);
            }
            System.out.println();
            inpue.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
