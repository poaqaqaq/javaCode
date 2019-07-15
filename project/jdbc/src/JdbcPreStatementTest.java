import org.junit.Test;
import util.JdbcUtil;

import java.sql.*;

/*
* PreparedStatement vs Statement
		1）语法不同：PreparedStatement可以使用预编译的sql，而Statement只能使用静态的sql
		2）效率不同： PreparedStatement可以使用sql缓存区，效率比Statement高(MYSQL不支持)
		3）安全性不同： PreparedStatement可以有效防止sql注入，而Statement不能防止sql注入。
* */

public class JdbcPreStatementTest {
    @Test
    public void dmlTest() {
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            //预编译Sql语句，能防止SQL注入
            preparedStatement = connection.prepareStatement("delete from basics where id = ?");
            //设置参数的位置值（位置索引，位置对应的值），位置索引从1开始算
            preparedStatement.setInt(1, 4);
            //执行，此处于普通statement不一样，不再需要传入sql语句，上面已经预编译过了
            int i = preparedStatement.executeUpdate();
            System.out.println(i + "行受影响");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection, preparedStatement);
        }
    }

    @Test
    public void dmlTest2() {
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            //预编译Sql语句，能防止SQL注入
            preparedStatement = connection.prepareStatement("insert into basics values(null,?,?,?,?,?)");
            //设置参数的位置值（位置索引，位置对应的值），位置索引从1开始算
            preparedStatement.setString(1, "cn_content");
            preparedStatement.setString(2, "en_content");
            preparedStatement.setInt(3, 2);
            //插入datetime类型，要使用timeStamp才可
            //java.sql.Timestamp是java.util.Date的子类，不需要做任何转换直接赋值即可
            preparedStatement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            preparedStatement.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            //执行，此处于普通statement不一样，不再需要传入sql语句，上面已经预编译过了
            int i = preparedStatement.executeUpdate();
            System.out.println(i + "行受影响");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection, preparedStatement);
        }
    }
}
