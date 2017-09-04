package com.zhihuishu.thread.waitAndNotify.productAndConsumer.pAndcUserStack;

/**
 * Created by Administrator on 2017/4/15.
 */
public class Run {

    /**
     * 一个生产者和一个消费者，生产者和消费者问题操作栈
     * @param args
     */
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        P p = new P(myStack);
        C c = new C(myStack);
        P_Thread p_thread = new P_Thread(p);
        C_Thread c_thread = new C_Thread(c);
        p_thread.start();
        c_thread.start();
    }

    /**
     *  多个生产者一个消费者
     * @param args
     */
    public static void main2(String[] args) {
        MyStack myStack = new MyStack();
        P p1 = new P(myStack);
        P p2 = new P(myStack);
        P p3 = new P(myStack);
        P p4 = new P(myStack);
        P p5 = new P(myStack);
        C c = new C(myStack);
        P_Thread p_thread1 = new P_Thread(p1);
        P_Thread p_thread2 = new P_Thread(p2);
        P_Thread p_thread3 = new P_Thread(p3);
        P_Thread p_thread4 = new P_Thread(p4);
        P_Thread p_thread5 = new P_Thread(p5);
        C_Thread c_thread = new C_Thread(c);
        p_thread1.start();
        p_thread2.start();
        p_thread3.start();
        p_thread4.start();
        p_thread5.start();
        c_thread.start();
    }

    /**
     * 多个生产者多个消费者
     * @param args
     */
    public static void main3(String[] args) {
        MyStack myStack = new MyStack();
        P p1 = new P(myStack);
        P p2 = new P(myStack);
        P p3 = new P(myStack);
        P p4 = new P(myStack);
        P p5 = new P(myStack);
        C c1 = new C(myStack);
        C c2 = new C(myStack);
        P_Thread p_thread1 = new P_Thread(p1);
        P_Thread p_thread2 = new P_Thread(p2);
        P_Thread p_thread3 = new P_Thread(p3);
        P_Thread p_thread4 = new P_Thread(p4);
        P_Thread p_thread5 = new P_Thread(p5);
        C_Thread c_thread1 = new C_Thread(c1);
        C_Thread c_thread2 = new C_Thread(c2);
        p_thread1.start();
        p_thread2.start();
        p_thread3.start();
        p_thread4.start();
        p_thread5.start();
        c_thread1.start();
        c_thread2.start();
    }
}
