package com.zhihuishu.junit.proxy.cglib;

/**
 * Created by Administrator on 2018/4/30.
 */
public class CglibProxy {
    public static void main(String[] args) {
        //目标对象
        UserDao target = new UserDao();

        //代理对象
        UserDao proxy = (UserDao)new ProxyFactory(target).getProxyInstance();

        //执行代理对象的方法
        proxy.save();
    }

}
