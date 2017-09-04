package com.zhihuishu.thread.junit;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by Administrator on 2017/4/6.
 */
public class HashMapTest {
    public static void main(String[] args) {

        Math.random();

        final HashMap<String, String> map = new HashMap<String, String>(2);
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i<1000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(), "");
                        }
                    }, "ftf" +i).start();
                }
            }
        }, "ftf");
        t.start();;
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
