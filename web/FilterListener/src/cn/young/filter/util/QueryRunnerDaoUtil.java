package cn.young.filter.util;

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
* 1）BeanHandler: 查询返回单个对象
  2）BeanListHandler: 查询返回list集合，集合元素是指定的对象
  3)  ArrayHandler, 查询返回结果记录的第一行，封装对对象数组, 即返回：Object[]
  4)  ArrayListHandler, 把查询的每一行都封装为对象数组，再添加到list集合中
  5)  ScalarHandler 查询返回结果记录的第一行的第一列  (在聚合函数统计的时候用)
  6)  MapHandler  查询返回结果的第一条记录封装为map,key为字段名，value为字段值
* */

public class QueryRunnerDaoUtil {
    static {
        ConvertUtils.register(new DateLocaleConverter(), Date.class);
    }

    public static void update(String sql, Object... params) {
        Connection connection = JdbcUtil.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        try {
            //执行更新语句操作，如果不想每次执行操作都传入Connection对象，则可以在实例化QueryRunner时传入DataSource对象
            queryRunner.update(connection, sql, params);//直接将可变参数当成参数传入
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection);
        }
    }

    //static <T>，此处的<T>为声明泛型，Class<T>这里的是使用泛型
    public static <T> T query4OneObject(String sql, Class<T> tClass, Object... params) {
        Connection connection = JdbcUtil.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        T t = null;
        try {
            //query会自行处理 PreparedStatement 和 ResultSet 的创建和关闭；
            //可以自己手写ResultSetHandler的接口实现，handler是控制返回数据的格式
           /* t = queryRunner.query(connection, sql, new ResultSetHandler<T>() {
                @Override
                public T handle(ResultSet resultSet) throws SQLException {
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int count = metaData.getColumnCount();
                    T t1 = null;
                    try {
                        t1 = tClass.newInstance();
                    } catch (InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    while (resultSet.next()) {
                        for (int i = 1; i <= count; i++) {
                            try {
                                BeanUtils.copyProperty(t1, metaData.getColumnName(i), resultSet.getObject(i));
                            } catch (Exception e) {
                                e.printStackTrace();
                                throw new RuntimeException(e);
                            }
                        }
                    }
                    return t1;
                }
            }, params);*/
            //使用内置的handler来获取返回数据，BeanHandler返回Bean
            t = queryRunner.query(connection, sql, new BeanHandler<>(tClass), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection);
        }
        return t;
    }

    public static <T> List<T> query4List(String sql, Class<T> tClass, Object... params) {
        Connection connection = JdbcUtil.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        List<T> list = null;
        try {
            //该方法会自行处理 PreparedStatement 和 ResultSet 的创建和关闭,BeanListHandler返回BeanList
            list = queryRunner.query(connection, sql, new BeanListHandler<>(tClass), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection);
        }
        return list;
    }

    public static <T> T query4Scalar(String sql, Object... params) {
        Connection connection = JdbcUtil.getConnection ();
        QueryRunner queryRunner = new QueryRunner();
        T t = null;
        try {
            //newInstance()主要作用是在内存中生成一个实例，而这个方法在使用前必须得保证：①这个类被加载到内存中，②这个类已经被连接，而完成以上两个过程的是Class.forName()方法。
            //弱类型,效率低,只能调用无参构造
//            t = tClass.newInstance();
//            Long long1=new Long();
            //该方法会自行处理 PreparedStatement 和 ResultSet 的创建和关闭,BeanListHandler返回BeanList
            t = queryRunner.query(connection, sql, new ScalarHandler<>(), params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection);
        }
        return t;
    }

    //此处没有设置泛型T的值（方法时，在参数中声明T的值），所以这里的T是Object，调用时可用List<String>,List<Integer>接收
    public static <T> List<T> query4Column(String sql, Object... params) {
        Connection connection = JdbcUtil.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        List<T> list = null;
        try {
            list = queryRunner.query(connection, sql, new ColumnListHandler<>(), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection);
        }
        return list;
    }

    public static void batchUpdate(String sql, Object[][] params) {
        Connection connection = JdbcUtil.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        try {
            queryRunner.batch(connection, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection);
        }
    }
}
