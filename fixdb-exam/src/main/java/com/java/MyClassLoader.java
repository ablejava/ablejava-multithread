package com.java;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {

    private String name ;// 类加载器的名字

    private String path="d:\\";

    private final String fileType =".class";

    public MyClassLoader(String name){
        super();
        this.name = name;
    }

    public MyClassLoader(ClassLoader parent, String name){
        super(parent);
        this.name = name;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = this.loadClassData(name);
        return this.defineClass(name,bytes,0,bytes.length);
    }

    private byte[] loadClassData(String name){

        InputStream is =null;
        byte[] data = null;

        ByteArrayOutputStream baos = null;

        try {

            this.name = this.name.replaceAll(".","\\");

            is = new FileInputStream(new File(path+name+fileType));

            int ch =0;
            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }
            data = baos.toByteArray();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            }catch (Exception e){

            }
        }

        return data;
    }


    public static void main(String[] args) {
        MyClassLoader loader1 = new MyClassLoader("loader1");
        loader1.setPath("");
    }

    public static void test(ClassLoader loader) throws Exception{
        Class<?> simple = loader.loadClass("com.java.Simple");
        simple.newInstance();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileType() {
        return fileType;
    }




}
