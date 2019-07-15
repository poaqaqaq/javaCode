import org.junit.Test;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JdbcStatementTest {
    @Test
    public void ddlTest() {
        Connection connection = JdbcUtil.getConnection();
        int i = 0;
        Statement statement = null;
        try {
            statement = connection.createStatement();
            //ddl即data defined language
            i = statement.executeUpdate("alter table contens add test varchar(45) not null");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection, statement);
        }
        System.out.println(i + "行受影响");
    }

    @Test
    public void dmlTest() {
        Connection connection = JdbcUtil.getConnection();
        int i = 0;
        Statement statement = null;
        try {
            statement = connection.createStatement();
            //ddl即data defined language
            i = statement.executeUpdate("insert into basics values(null,'cn_content','en_content',3,'2019-03-05 18:00:08','2019-03-05 18:00:08')");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection, statement);
        }
        System.out.println(i + "行受影响");
    }

    @Test
    public void dqlTest() {
        Connection connection = JdbcUtil.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            //如果不设置编码为utf8，会中文乱码，这里的utf8中间不需要加-
            statement.executeUpdate("set names utf8");
            //ddl即data defined language
            resultSet = statement.executeQuery("select * from basics");
            //next会移动行指针，如果查询出来的结果只有一行，则直接使用result.getXX()即可，不用next()
            while (resultSet.next()) {
                //用getXX(列名)或者getXX(列索引)都可以获取对应的值，列索引是从1开始计算的！
                int id = resultSet.getInt("id");
                //Timestamp在这里是获取日期/时间（包括年月日，时分秒，还有毫秒和纳秒） ，这里输出：2019-03-05 18:00:06.0
                Date date = resultSet.getTimestamp("created_at");
                //可以通过simpleDateFormat将它转换成字符串
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String date2 = simpleDateFormat.format(date);
                String string = resultSet.getString("cn_content");
                System.out.println("id:" + id + "，cn:" + string + "，date:" + date2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection, statement, resultSet);
        }
    }

    @Test
    public void dqlTest2() {
        Connection connection = JdbcUtil.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            //ddl即data defined language
            resultSet = statement.executeQuery("select count(*) from basics");
            resultSet.next();
            int id = resultSet.getInt(1);
            System.out.println(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection, statement, resultSet);
        }
    }
}
