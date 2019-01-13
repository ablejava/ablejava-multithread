package com.java;

import java.lang.reflect.Constructor;

public class NewClass {

    private NewClass() {
        System.out.println("new class");
    }
    private NewClass(int i, int j) {
        String format = String.format("i:%s:j:%s", i, j);
        System.out.println("new class"+format);
    }


    public static void main(String[] args) {
        try {/*可以使用相对路径，同一个包中可以不用带包路径*/
            Class c=Class.forName("com.java.NewClass");
            /*以下调用无参的、私有构造函数*/
            Constructor c0 =c.getDeclaredConstructor();
            c0.setAccessible(true);
            NewClass a0=(NewClass)c0.newInstance();
            /*以下调用带参的、私有构造函数*/
            Constructor c1=c.getDeclaredConstructor(new Class[]{int.class,int.class});
            c1.setAccessible(true);
            NewClass a1=(NewClass) c1.newInstance(new Object[]{5,6});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
