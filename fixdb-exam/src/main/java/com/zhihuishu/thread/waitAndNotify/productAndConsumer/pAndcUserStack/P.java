package com.zhihuishu.thread.waitAndNotify.productAndConsumer.pAndcUserStack;

/**
 * Created by Administrator on 2017/4/15.
 */
public class P {
    private MyStack myStack;
    public P(MyStack myStack){
        super();
        this.myStack = myStack;
    }
    public void pushService () {
        myStack.push();
    }
}
