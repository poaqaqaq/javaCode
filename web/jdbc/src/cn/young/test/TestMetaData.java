package cn.young.test;

import cn.young.util.JdbcUtil;
import org.junit.Test;

import java.sql.*;

public class TestMetaData {
    @Test
    public void dbMetaTest() {
        Connection connection = JdbcUtil.getConnection();
        try {
            //获取数据库的元信息
            DatabaseMetaData metaData = connection.getMetaData();
            //获取元信息中的用户名：root@172.17.0.1
            System.out.println(metaData.getUserName());
            //获取元信息中的主要版本，大版本：5
            System.out.println(metaData.getDatabaseMajorVersion());
            //获取详细版本信息:5.7.24-log
            System.out.println(metaData.getDatabaseProductVersion());
            //获取名称:MySQL
            System.out.println(metaData.getDatabaseProductName());
            //获取连接URL：jdbc:mysql://localhost:3307/snarte?characterEncoding=UTF-8
            System.out.println(metaData.getURL());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection);
        }
    }

    /**
     * 获取执行后的结果集元数据
     */
    @Test
    public void prepareColumnMetaTest() {
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
//            preparedStatement = connection.prepareStatement("insert into basics values(null,?,?,?,?,?)");
//            preparedStatement.setString(1, "cn_content");
//            preparedStatement.setString(2, "en_content");
//            preparedStatement.setInt(3, 2);
//            preparedStatement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
//            preparedStatement.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            //打印出最终执行的sql：insert into basics values(null,'cn_content','en_content',2,'2019-07-26 12:04:41','2019-07-26 12:04:41')
//            System.out.println(preparedStatement.toString());

            preparedStatement = connection.prepareStatement("select * from basics");
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            //column索引都是从1开始算起！
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                //获取SQL字段对应的JAVA类的名称，如果SQL字段是int，则返回：java.lang.Long；varchar则返回String；
                // tinyint则返回Integer；DateTime则返回java.sql.Timestamp
                System.out.print("className:" + metaData.getColumnClassName(i) + "\t\t");
                //获取指定列的SQL类型对应于Java中Types类的字段
                System.out.print("columnType:" + metaData.getColumnType(i) + "\t\t");
                System.out.println();
                //获取指定列的SQL类型名称
                System.out.print("typeName:" + metaData.getColumnTypeName(i) + "\t\t");
                //获取指定列名
                System.out.print("columnName:" + metaData.getColumnName(i) + "\t\t");
                System.out.println();
                System.out.println("---------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection, preparedStatement);
        }
    }

    /**
     * 获取参数的元数据
     */
    @Test
    public void prepareParamMetaTest() {
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            //mysql驱动默认generateSimpleParameterMetadata=false，
            // 在传入null参数的时候，生成不了有效的元数据，因此才会报错:java.sql.SQLException: Parameter metadata not available for the given statement
            //所以在sql的连接语句url中配置此参数为true即可
            preparedStatement = connection.prepareStatement("insert into basics values(null,?,?,?,?,?)");
            ParameterMetaData pm = preparedStatement.getParameterMetaData();
            for (int i = 1; i <= pm.getParameterCount(); i++) {
                System.out.print("className:" + pm.getParameterClassName(i) + "\t\t");
                System.out.print("mode:" + pm.getParameterMode(i) + "\t\t");
                System.out.println();
                System.out.print("type:" + pm.getParameterType(i) + "\t\t");
                System.out.print("typeName:" + pm.getParameterTypeName(i) + "\t\t");
                System.out.println();
                System.out.println("---------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection, preparedStatement);
        }
    }
}
