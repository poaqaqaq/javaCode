package cn.young.util;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseDaoUtil {
    static {
        ConvertUtils.register(new DateLocaleConverter(), Date.class);
    }

    public static void update(String sql, Object... params) {
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();
            int count = parameterMetaData.getParameterCount();
            if (count != 0 && params != null) {
                //字段索引都是从1开始
                for (int i = 1; i <= count; i++) {
                    //因为... params是数组，所以这里要i-1
                    preparedStatement.setObject(i, params[i - 1]);
                }
            }
            //打印最终执行的sql
            System.out.println(preparedStatement.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection, preparedStatement);
        }
    }

    public static <T> List<T> query(String sql, Class<T> tClass, Object... params) {
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement preparedStatement = null;
        List<T> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            int count = preparedStatement.getParameterMetaData().getParameterCount();
            if (count != 0 && params != null) {
                for (int i = 1; i <= count; i++) {
                    preparedStatement.setObject(i, params[i - 1]);
                }
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            count = metaData.getColumnCount();
            while (resultSet.next()) {
                T t = tClass.newInstance();
                for (int i = 1; i <= count; i++) {
                    String name = metaData.getColumnName(i);
                    BeanUtils.copyProperty(t, name, resultSet.getObject(i));
                }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection, preparedStatement);
        }
        return list;
    }
}
