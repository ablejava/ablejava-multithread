package com.zhihuishu.thread.lock.lockSync;

/**
 * Created by Administrator on 2017/4/25.
 */
public class Run {
    public static void main(String[] args) {
        /**
         *  使用了lock.lock()代码的线程就持有了“对象监视器” 其他线程只有等待锁被释放时再次争抢，效果和使用synchronized关键字是一样的线程之间执行的顺序是随机的
         */
        MyService service = new MyService();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();
        ThreadAA AA = new ThreadAA(service);
        AA.setName("B");
        AA.start();

        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();

        ThreadBB bb = new ThreadBB(service);
        bb.setName("BB");
        bb.start();
    }
}
