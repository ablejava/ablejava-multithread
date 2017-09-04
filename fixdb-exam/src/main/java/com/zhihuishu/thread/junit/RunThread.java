package com.zhihuishu.thread.junit;

/**
 * Created by Administrator on 2017/4/6.
 */
public class RunThread extends Thread{
    private boolean isRunning = true;
    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    @Override
    public void run() {
        System.out.println("进入 run 了");
        while (isRunning) {

        }

        System.out.println(" 线程被停止了");
    }
}

class RunSynRunThread{
    public static void main(String[] args) {
        RunThread thread = new RunThread();
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.setRunning(false);
        System.out.println("已经赋值为 false");
    }
}