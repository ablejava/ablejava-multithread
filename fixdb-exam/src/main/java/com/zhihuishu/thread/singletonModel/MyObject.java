package com.zhihuishu.thread.singletonModel;

/**
 * Created by Administrator on 2017/4/28.
 */
public class MyObject {
    private volatile static MyObject myObject;
    private MyObject() {

    }

    // 使用双检测机制来解决，既保证了不需要同步代码块的异步执行性
    // 有保证了单例的效果
    public static MyObject getInstance() {
        try {
            if (myObject == null) {
                // 模拟在创建对象之前做一些准备工作
                Thread.sleep(3000);
                synchronized (MyObject.class) {
                    if (myObject == null) {
                        myObject = new MyObject();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  myObject;
    }

}
