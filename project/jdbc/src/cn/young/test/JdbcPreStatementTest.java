package cn.young.test;

import cn.young.entity.Basic;
import org.junit.Test;
import cn.young.util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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


    public List<Basic> getList() {
        Random random = new Random();
        List<Basic> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            Basic basic = new Basic();
            basic.setCn_content("中文内容" + i);
            basic.setEn_content("english" + i);
            //nextInt范围：0-3，但是不包括3
            basic.setType(random.nextInt(3) + 1);
            basic.setCreated_at(new Timestamp(System.currentTimeMillis()));
            basic.setUpdated_at(new Timestamp(System.currentTimeMillis()));
            list.add(basic);
        }
        return list;
    }

    @Test
    /*
    * 	void addBatch(String sql)     添加批处理
		void clearBatch()            清空批处理
        int[] executeBatch()         执行批处理
    * */
    public void batch() {
        List<Basic> list = getList();
        Connection connection = JdbcUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into basics values(null,?,?,?,?,?)");
            int i = 0;
            for (Basic basic : list) {
                preparedStatement.setString(1, basic.getCn_content());
                preparedStatement.setString(2, basic.getEn_content());
                preparedStatement.setInt(3, basic.getType());
                preparedStatement.setTimestamp(4, basic.getCreated_at());
                preparedStatement.setTimestamp(5, basic.getUpdated_at());
                //设置完参数后加入到batch中
                preparedStatement.addBatch();
                i++;
                if (i % 5 == 0) {
                    //每5个batch执行一次
                    int[] ints = preparedStatement.executeBatch();
                    System.out.println(Arrays.toString(ints));
                    //执行完后要清除batch
                    preparedStatement.clearBatch();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
