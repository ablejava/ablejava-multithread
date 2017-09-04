package com.zhihuishu.thread.pipeStream;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * Created by Administrator on 2017/4/15.
 */
public class ReadDate {

    public void readMethod(PipedInputStream inpue) {
        try {
            System.out.println("read :");
            byte[] byteArray = new byte[20];
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
