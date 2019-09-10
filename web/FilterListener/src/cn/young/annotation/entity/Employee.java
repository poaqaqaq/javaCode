package cn.young.annotation.entity;

import java.util.concurrent.locks.Condition;

import cn.young.annotation.annotation.Column;
import cn.young.annotation.annotation.Id;
import cn.young.annotation.annotation.Table;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.util.Date;

@Table(tableName = "employee_copy1")
public class Employee {
    //如果
    @Column("a_name")
    private String name;
    private int age;
    private String sex;
    //如果声明了多个属性，则value名也必须写出来！
    @Column(value = "date", type = "Date")
    private Date date;
    @Id
    private int id;
    @Column("a_password")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //unused压制工具提示的方法的未使用的警告，unchecked压制工具提示的未检查类警告：list list=n
    //
    //
    // ew List();
    @SuppressWarnings({"unused","unchecked"})
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", date=" + date +
                ", id=" + id +
                ", password='" + password + '\'' +
                '}';
    }
}
