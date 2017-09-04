package com.zhihuishu.thread.singletonModel;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/28.
 */
public class UseStaticInnerClass implements Serializable{

    // 内部类方式
    private static class MyObjectHandler {
        private static final UseStaticInnerClass myObject = new UseStaticInnerClass();
    }

    private UseStaticInnerClass () {
    }

    public static UseStaticInnerClass getInstance() {
        return MyObjectHandler.myObject;
    }

    protected Object readResolve() throws ObjectStreamException {
        System.out.println("调用了 readResolve 方法");
        return MyObjectHandler.myObject;
    }
}
