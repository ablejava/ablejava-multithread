package com.zhihuishu.thread.waitAndNotify.productAndConsumer.pAndcUserStack;

/**
 * Created by Administrator on 2017/4/15.
 */
public class C {
    private MyStack myStack;
    public C(MyStack myStack){
        super();
        this.myStack = myStack;
    }

    public void popService() {
        System.out.println("pop = " + myStack.pop());
    }
}
