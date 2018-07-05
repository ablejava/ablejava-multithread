package com.zhihuishu.basic.extendsClass;

/**
 * Created by Administrator on 2018/4/30.
 */
public class Sort {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.setAge(12);
        e1.setName("a");
        /*Employee e2 = new Employee();
        e2.setAge(11);
        Object[] arry = {e1, e2};
        if (e1.compareTo(e2) == 1){
            System.out.println("1比2大");
        } else {
            System.out.println("1比2小");
        }*/

        Integer parent = 12;
        String d = "";
        Object c =d;

        try {
            Employee clone = e1.clone();
            clone.setAge(13);
            /*clone.setAge(13);
            clone.setName("b");*/
            if (e1 == clone) {
                System.out.println("e1=====clone");
            } else {
                System.out.println("e1 != clone");
            }
            if (e1.getName() == clone.getName()){
                System.out.println("克隆的对象是同一个对象");
            } else {
                System.out.println("不是同一个对象");
            }

            System.out.println(e1.getAge());
            System.out.println(clone.getAge());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
