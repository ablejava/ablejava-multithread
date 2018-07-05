package com.zhihuishu.junit;

/**
 * Created by Administrator on 2017/3/28.
 * 传统线程同步
 */
public class TraditionalThreadSynchronized {

    public static void main(String[] args) {
        new TraditionalThreadSynchronized().init();
    }
    private void init(){
        /**
         *  静态方法中不能创建内部类的对象
         *  内部类可以访问外部类的成员变量，成员变量是对象身上的，内部类可以访问成员变量说明已经有了实例对象
         *  与之矛盾
         */
        final OutPuter outPuter = new OutPuter();
        // Thread 1
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outPuter.output("xiazhongwei");
                }
            }
        }).start();

        // Thread 2
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outPuter.output("zhihuishu");
                }
            }
        });
    }
    static class OutPuter{
        // 保持线程互斥
        public void output(String name) {
            int len = name.length();
            synchronized (OutPuter.class){ // 当前OutPuter对象
                for (int i =0; i<len; i++) {
                    System.out.print(name.charAt(i));
                }
                System.out.println();
            }
        }

        public synchronized void output2(String name) {
            int len = name.length();
            synchronized (name){
                for (int i =0; i<len; i++) {
                    System.out.print(name.charAt(i));
                }
                System.out.println();
            }
        }

        public static synchronized void output3(String name) {
            int len = name.length();
            for (int i =0; i<len; i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }
    }
}
