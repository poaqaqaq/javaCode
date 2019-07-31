package cn.young.test;

import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

class Animal {
    protected int a=5;
    public void say() {
        System.out.println("from animal");
    }
}

class Cat extends Animal {
    int a=6;
    public void jump() {
        System.out.println("from cat");
    }
}

public class JdbcTest {
    //URL格式： jdbc协议:数据库子协议://主机:端口/连接的数据库
    //如果是localhost:3306则可以忽略简写成：jdbc:mysql:///snarte
    private String url = "jdbc:mysql://localhost:3307/snarte";
    private String username = "root";
    private String password = "mysql123";

    //使用Mysql提供的驱动获取数据库连接
    @Test
    public void testConnection() throws SQLException {
        Driver driver = new com.mysql.jdbc.Driver();//新版
//        Driver driver=new org.gjt.mm.mysql.Driver();//旧版
        Properties properties = new Properties();
        properties.setProperty("user", username);
        properties.setProperty("password", password);
        //connect需要一个properties，properties中包含user与password
        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
        //记得关闭资源
        connect.close();
    }

    @Test
    public void testConnection2() throws SQLException {
        Driver driver = new com.mysql.jdbc.Driver();
        //DriverManager会解析url的数据库类型自动注入，所以这里不用register;
        DriverManager.registerDriver(driver);
        //可以注册多个
//        DriverManager.registerDriver();
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println(connection);
        connection.close();
    }

    @Test
    public void testConnection3() throws ClassNotFoundException, SQLException {
        //直接加载mysql的jdbc类，DriverManager会自动搜寻并注册git
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println(connection);
        connection.close();
    }

    @Test
    public void test() {
        Animal cat = new Cat();
        //当使用多态方式调用方法时，首先检查父类中是否有该方法，如果没有，则编译错误；如果有，再去调用子类的同名方法。
//        cat.jump();
        //所以要想调用子类特有的方法只能先强转为子类
        ((Cat) cat).jump();
        cat.say();
        System.out.println(cat.a);
    }
}
