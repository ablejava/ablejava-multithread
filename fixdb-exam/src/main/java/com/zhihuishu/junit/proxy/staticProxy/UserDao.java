package com.zhihuishu.junit.proxy.staticProxy;

/**
 * Created by Administrator on 2018/4/30.
 */
public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("----已经保存数据!----");
    }
}
