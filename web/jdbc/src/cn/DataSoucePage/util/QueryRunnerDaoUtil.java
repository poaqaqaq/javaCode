package cn.DataSoucePage.util;

import cn.young.util.JdbcUtil;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/*
* 使用C3P0连接池对象初始化QueryRunner，之后则不需要再传入Connection对象
* */

public class QueryRunnerDaoUtil {
    private static ComboPooledDataSource comboPooledDataSource;

    static {
        ConvertUtils.register(new DateLocaleConverter(), Date.class);
        comboPooledDataSource = new ComboPooledDataSource();
    }

    public static void update(String sql, Object... params) {
        //实例化时直接使用DataSource对象，则在之后的操作不用再传入connection对象
        QueryRunner queryRunner = new QueryRunner(comboPooledDataSource);
        try {
            queryRunner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //static <T>，此处的<T>为声明泛型，Class<T>这里的是使用泛型
    public static <T> T query4OneObject(String sql, Class<T> tClass, Object... params) {
        QueryRunner queryRunner = new QueryRunner();
        T t = null;
        try {
            //使用内置的handler来获取返回数据，BeanHandler返回Bean
            t = queryRunner.query(sql, new BeanHandler<>(tClass), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }

    public static <T> List<T> query4List(String sql, Class<T> tClass, Object... params) {
        QueryRunner queryRunner = new QueryRunner(comboPooledDataSource);
        List<T> list = null;
        try {
            //该方法会自行处理 PreparedStatement 和 ResultSet 的创建和关闭,BeanListHandler返回BeanList
            list = queryRunner.query(sql, new BeanListHandler<>(tClass), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static <T> T query4Scalar(String sql, Object... params) {
        QueryRunner queryRunner = new QueryRunner(comboPooledDataSource);
        T t = null;
        try {
            t = queryRunner.query(sql, new ScalarHandler<>(), params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    //此处没有设置泛型T的值（方法时，在参数中声明T的值），所以这里的T是Object，调用时可用List<String>,List<Integer>接收
    public static <T> List<T> query4Column(String sql, Object... params) {
        QueryRunner queryRunner = new QueryRunner(comboPooledDataSource);
        List<T> list = null;
        try {
            list = queryRunner.query(sql, new ColumnListHandler<>(), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void batchUpdate(String sql, Object[][] params) {
        QueryRunner queryRunner = new QueryRunner(comboPooledDataSource);
        try {
            queryRunner.batch(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
