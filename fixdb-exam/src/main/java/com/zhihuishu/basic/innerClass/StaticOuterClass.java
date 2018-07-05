package com.zhihuishu.basic.innerClass;

/**
 * Created by Administrator on 2018/4/30.
 */
public class StaticOuterClass {
    private static String outerName;
    public  int age;

    static class InnerClass1{
        /* 在静态内部类中可以存在静态成员 */
        public static String _innerName = "static variable";
        public void display(){
            /*
             * 静态内部类只能访问外部类的静态成员变量和方法
             * 不能访问外部类的非静态成员变量和方法
             */
            System.out.println("OutClass name :" + outerName);
        }
    }
    class InnerClass2{
        /* 非静态内部类中不能存在静态成员 */
        public String _innerName = "no static variable";
        /* 非静态内部类中可以调用外部类的任何成员,不管是静态的还是非静态的 */
        public void display(){
            System.out.println("OuterClass name：" + outerName);
            System.out.println("OuterClass age：" + age);
        }
    }
    public void display(){
        /* 外部类能直接访问静态内部类静态元素 */
        System.out.println(InnerClass1._innerName);
        /* 静态内部类可以直接创建实例不需要依赖于外部类 */
        new InnerClass1().display();
        /* 非静态内部的创建需要依赖于外部类 */
        StaticOuterClass.InnerClass2 inner2 = new StaticOuterClass().new InnerClass2();
        /* 非静态内部类的成员需要使用非静态内部类的实例访问 */
        System.out.println(inner2._innerName);
        inner2.display();
    }

    public static void main(String[] args) {
        StaticOuterClass outer = new StaticOuterClass();
        outer.display();
    }
}
