package cn.young.util;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class BaseDaoUtil {
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
//            System.out.println(preparedStatement.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection, preparedStatement);
        }
    }

}
