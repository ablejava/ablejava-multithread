package com.zhihuishu.thread.junit;

/**
 * Created by Administrator on 2017/4/5.
 */
public class StrringAndSyn {
    public static void main (String[] args){
        StringService stringService = new StringService();
        ThreadStringSynA a = new ThreadStringSynA(stringService);
        a.setName("AA");
        a.start();
        ThreadStringSynB b = new ThreadStringSynB(stringService);
        b.setName("BB");
        b.start();
    }

}
class StringService {
    public static void print(String stringParam) {
        /**
         * synchronized (string)如果String 用的同一个对象，两个线程就拥有相同的锁
         */
        synchronized (stringParam) {
            while (true) {
                System.out.println(Thread.currentThread().getName() + "********CurrentThread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class ThreadStringSynA extends Thread{
    private StringService stringService;
    public ThreadStringSynA(StringService stringService) {
        super();
        this.stringService = stringService;
    }

    @Override
    public void run() {
        stringService.print("ThreadStringSynA");
    }
}

class ThreadStringSynB extends Thread{
    private StringService stringService;
    public ThreadStringSynB(StringService stringService) {
        super();
        this.stringService = stringService;
    }

    @Override
    public void run() {
        stringService.print("ThreadStringSynA");
    }
}