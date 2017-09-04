package com.zhihuishu.thread.lock.singleLock;

public class TestStaticField {
	private static int a;
	public static int testA(){
		return a++;
	}
	public static void main(String[] args){
	
		System.out.println(testA());
	}
}
