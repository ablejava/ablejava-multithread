/**
 * 版权所有(C) ZHIHUISHU 2015-2025
 * Copyright 2015-2025 ZHIHUISHU
 * 创建日期：2016年3月21日上午11:13:07
 * 创建人：Andy.Yang
 */
package com.zhihuishu.thread.junit;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Test {
	public static void main(String[] args) throws Exception{
		Set<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		set.add(6);
		set.add(7);
		set.add(8);
		set.add(9);
		set.add(10);
		//set.iterator().hasNext()
		for (;set.iterator().hasNext();) {
			System.out.println(set.iterator().next());
		}
		
		System.out.println(set);
		//System.out.println(get());
		/*List<Integer> l = new ArrayList<Integer>();
		for(int i=0;i<10;i++){
			l.add(i);
		}
		System.out.println(l.subList(10, 10));*/
		/*String str = "121";
		StringBuilder sb = new StringBuilder();
		String[] array = str.split(",");
		for(String key:array){
			sb.append(key).append(",");
		}
		System.out.println(sb.substring(0, sb.length()-1));*/
		/*List<Integer> list = new ArrayList<Integer>();
		list.add(11);
		list.add(12);
		list.add(13);
		System.out.println(list);
		list.add(0, 10);
		System.out.println(list);*/
		
		/**
		 *  java.lang.Class 是反射的源头
		 *  我们创建了一个类，通过编译（javac.exe）生成对应的class文件，之后我们通过java.exe加载(jvm的类加载器加载)此class文件
		 *  此class文件加载到内存后，就是一个运行时类，存在缓存区，这个运行时类本事就是一个Class的实例
		 *  每一个运行时类只加载一次，
		 */
		/*Class<StudentExam> clazz = StudentExam.class;
		StudentExam studentExam = clazz.newInstance();
		System.err.println(studentExam);
		
		System.out.println(clazz);
		// Field field = clazz.getField("id"); // 通过属性调用运行时类的指定属性：属性是public类型
		Field field = clazz.getDeclaredField("id"); // 属性是非public 类型
		Field[] fields = clazz.getDeclaredFields(); // 获取运行时类本身(父类不行)所有声明的属性，父类使用clazz.getFields();
		for (Field field2 : fields) {
			int i = field2.getModifiers();
			String type = Modifier.toString(i);// 获取字段属性的数据类型
			System.out.println(type);
		}
		field.setAccessible(true);
		field.set(studentExam, 11);
		System.err.println(studentExam.getId());
		
		// 通过反射调用运行时类的指定方法
		Method method = clazz.getMethod("setId", Integer.class);
		method.invoke(studentExam, 123); // 调用运行时类的指定方法
		Method[] methods = clazz.getMethods(); // 获取所有运行时类及其父类中所有声明为public的方法
		Method[] methods2 = clazz.getDeclaredMethods();// 获取运行时类本身类中声明的方法
		for (Method method2 : methods) {
			System.out.println(method2.getName());
		}
		
		// * 通过对象的getClass()方法获取对象的运行时类，
		Exam exam = new Exam();
		Class clazzExam = exam.getClass();
		
		// 类加载器
		Test test = new Test();
		test.classLoader();*/
		
		
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
	
	public static List<Integer> get()throws Exception{
		System.out.println(Thread.currentThread().getId()+" "+Thread.currentThread().getName()+"开始运行。。。。。。");
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<5;i++){
			list.add(i);
		}
		Thread.currentThread().sleep(3000);
		System.out.println(Thread.currentThread().getId()+" "+Thread.currentThread().getName()+"结束运行。。。。。。");
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(Thread.currentThread().getId()+" "+Thread.currentThread().getName()+"开始运行");
				try {
					Thread.currentThread().sleep(5000);
					System.out.println(Thread.currentThread().getId()+" "+Thread.currentThread().getName()+"结束运行");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		return list;
		
	}
}
