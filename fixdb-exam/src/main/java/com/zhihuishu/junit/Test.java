/**
 * 版权所有(C) ZHIHUISHU 2015-2025
 * Copyright 2015-2025 ZHIHUISHU
 * 创建日期：2016年3月21日上午11:13:07
 * 创建人：Andy.Yang
 */
package com.zhihuishu.junit;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Test {
	
	public static boolean t(Integer studentExamId, String classId){
		if(studentExamId == null ){
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(t(1111, "2222"));
		
		
		/*final Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "1");
		map.put(2, "2");
		map.put(3, "3");
		
		for(Integer i : map.keySet()){
			map.put(i, i+""+i);
			if(i==2){
				map.remove(i);
			}
		}
		System.out.println(map);*/
		
	}
	/**
	 * Description:类加载器，加载xx.properties文件，并读取数据
	 * @param 
	 * @author xiazhongwei
	 * @data 2016年9月29日:下午5:32:56
	 * @return
	 */
	public void classLoader() throws IOException {
		//方法一、从当前工程下加载
		ClassLoader loader = this.getClass().getClassLoader();
		// 路径是包下写：com\\able\\onlineExam\\resources\\config.properties
		InputStream inStream = loader.getResourceAsStream("config.properties");
		// 方法二、从指定的路径下加载文件
		// FileInputStream fileInputStream = new FileInputStream(new File("config.properties"));
		
		Properties properties = new Properties();
		properties.load(inStream);
		// properties.load(fileInputStream);
		String prop = properties.getProperty("domain");
		System.out.println(prop);
	}
	
	public void dynamicProxy(){
		/**
		 * 静态代理:代理类和目标对象的类型都是在编译期间确定下来，不利于程序的扩展。同时每个代理类只能为一个接口服务，这样一来程序开发中必然产生过多的代理。
		 * 动态代理:客户通过代理类来调用其他对象的方法，并且是在程序运行时，根据需要动态创建目标类的代理对象。
		 * 		动态代理使用场合：
		 * 			调试》
		 * 			远程方法调用》
		 * 代理设计模式的原理：
		 *  使用一个代理将对象包装起来，然后用该代理对象取代原始对象，任何对原始对象的调用都要通过代理，代理对象决定的那个是否以及何时将方法调用
		 */
	}
	
	public static List<Integer> get()throws Exception {
		System.out.println(Thread.currentThread().getId()+" "+ Thread.currentThread().getName()+"开始运行。。。。。。");
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<5;i++){
			list.add(i);
		}
		Thread.currentThread().sleep(3000);
		System.out.println(Thread.currentThread().getId()+" "+ Thread.currentThread().getName()+"结束运行。。。。。。");
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(Thread.currentThread().getId()+" "+ Thread.currentThread().getName()+"开始运行");
				try {
					Thread.currentThread().sleep(5000);
					System.out.println(Thread.currentThread().getId()+" "+ Thread.currentThread().getName()+"结束运行");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		return list;
		
	}
}
