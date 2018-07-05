package com.zhihuishu.basic.innerClass;

/**
 * Created by Administrator on 2018/4/30.
 */
public class OuterClass {
    private String outerName;
    private int outerAge;

    public class InnerClass{
        private int innerName;
        InnerClass(){
            //内部类可以访问外部类的元素
            outerName="I am outer class";
            outerAge=23;
        }
        public void display(){
            System.out.println(outerName+" and my age is "+outerAge);
            // 通过OuterClass.this 引用外部类对象
            OuterClass.this.outerDisplay();
        }
    }

    public void outerDisplay() {
        System.out.println("this is outer class .....");
    }
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        innerClass.display();
    }
}
