package cn.DataSoucePage.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

public class C3p0Test {
    /*
     * 连接池对象，需要实现javax.sql.DataSource接口！
     * */

    /**
     * 硬编码方式实现C3P0配置
     */
    @Test
    public void test1() {
        ComboPooledDataSource comboPooledDataSource;
        //新版C3P0需要mchange-commons-java包的支持
        comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("mysql123");
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3307/snarte?characterEncoding=UTF-8");
        //设置初始化的池大小
        comboPooledDataSource.setInitialPoolSize(5);
        //设置最小连接池大小与MaxIdleTime合用
        comboPooledDataSource.setMinPoolSize(3);
        //设置最大空闲时间
        comboPooledDataSource.setMaxIdleTime(30);
        //设置最大连接池大小
        comboPooledDataSource.setMaxPoolSize(10);
        Connection connection = null;
        try {
            connection = comboPooledDataSource.getConnection();
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                Objects.requireNonNull(connection).close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2() {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        Connection connection = null;
        try {
            connection = comboPooledDataSource.getConnection();
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
