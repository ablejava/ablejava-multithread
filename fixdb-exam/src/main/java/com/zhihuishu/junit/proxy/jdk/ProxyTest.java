package com.zhihuishu.junit.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

	public static void main(String[] args) {
		RealSubject realSubject = new RealSubject();
		MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
		Object object = myInvocationHandler.bind(realSubject);
		Subject subject = (Subject) object;
		subject.action();
	}
}

// 动态代理的使用
interface Subject{
	void action();
}

// 被代理类
class RealSubject implements Subject{

	@Override
	public void action() {

		System.out.println("我是被代理类，记得执行我哦。。。。");
	}
	
}

class MyInvocationHandler implements InvocationHandler {

	Object object;// 实现了接口的被代理类的对象的声明
	/**
	 * Description:①给被代理的对象实例化 ②返回一个代理类对象
	 * @param 
	 * @author xiazhongwei
	 * @data 2016年9月29日:下午4:13:43
	 * @return
	 */
	public Object bind(Object object){
		this.object = object;
		return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
	}
	/**
	 * 当通过代理类的对象发起对被重写的方法的调用时，都会转化为对如下的invok方法的调用
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object returnObject = method.invoke(object, args);
		return returnObject;
	}
}