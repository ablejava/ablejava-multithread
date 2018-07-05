package com.zhihuishu.basic.extendsClass;

/**
 * Created by Administrator on 2018/4/30.
 */
public class Employee implements Comparable<Employee>, Cloneable {
    private Integer age;

    private String name;

    @Override
    public int compareTo(Employee o) {
        Employee employee = o;
        return employee.getAge().compareTo(age);
    }

    @Override
    protected Employee clone() throws CloneNotSupportedException {
        return (Employee) super.clone();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
