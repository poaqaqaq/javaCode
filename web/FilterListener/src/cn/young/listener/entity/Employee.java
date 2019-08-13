package cn.young.listener.entity;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.util.Date;

//绑定实体类到session属性增删中，不用配置web.xml，因为Employee对象是自己控制创建与销毁的！
public class Employee implements HttpSessionBindingListener {
    //当本实体对象被绑定到session属性时触发
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("Bind to entity");
    }

    //当本实体对象被从session属性解绑时触发
    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("Unbind From entity");
    }

    private String name;
    private int age;
    private String sex;
    private Date date;
    private int id;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "EmployeeDao{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", date=" + date +
                '}';
    }
}
