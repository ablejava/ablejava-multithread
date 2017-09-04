package com.zhihuishu.thread.singletonModel;

import java.io.*;

/**
 * Created by Administrator on 2017/4/28.
 */
public class SaveOrRead {
    public static void main(String[] args) {
        try {
            UseStaticInnerClass staticInnerClass = UseStaticInnerClass.getInstance();
            FileOutputStream fosRef = new FileOutputStream(new File("D:1.txt"));
            ObjectOutputStream outputStream = new ObjectOutputStream(fosRef);
            outputStream.writeObject(staticInnerClass);
            outputStream.close();
            fosRef.close();
            System.out.println(staticInnerClass.hashCode());
        } catch (Exception e){
            e.printStackTrace();
        }

        try {
            FileInputStream flsRef = new FileInputStream(new File("D:1.txt"));
            ObjectInputStream iosRef = new ObjectInputStream(flsRef);
            // ☆ 在反序列化过程中调用了readResolve()方法 ☆
            UseStaticInnerClass staticInnerClass = (UseStaticInnerClass) iosRef.readObject();
            iosRef.close();
            flsRef.close();
            System.out.println(staticInnerClass.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
