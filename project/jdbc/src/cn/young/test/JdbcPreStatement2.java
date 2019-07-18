package cn.young.test;

import cn.young.util.JdbcUtil;
import org.junit.Test;

import java.io.*;
import java.sql.*;

public class JdbcPreStatement2 {

    private Connection connection = JdbcUtil.getConnection();

    @Test
    //插入获取自增长ID
    public void testGetAutoIncrement() {
        PreparedStatement preparedStatement = null;
        try {
            //获取PrepareStatement的时候，需要设置获取自增长KEY的参数：PreparedStatement.RETURN_GENERATED_KEYS
            preparedStatement = connection.prepareStatement("insert into basics values(null,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, "cn_content");
            preparedStatement.setString(2, "en_content");
            preparedStatement.setInt(3, 2);
            //插入datetime类型，要使用timeStamp才可
            //java.sql.Timestamp是java.util.Date的子类，不需要做任何转换直接赋值即可
            preparedStatement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            preparedStatement.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            int count = preparedStatement.executeUpdate();
            //执行完后，获取自增长KEY，返回的是一个resultSet
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            System.out.println(count);
            if (generatedKeys.next()) {
                System.out.println(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection, preparedStatement);
        }
    }

    @Test
    //事务
    public void testTransaction() {
        connection = JdbcUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            //取消自动提交，JDBC不是通过begin等来开启事务，是通过设置自动提交的参数为OFF
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("insert into basics values(null,?,?,?,?,?)");

            preparedStatement.setString(1, "cn_content");
            preparedStatement.setString(2, "en_content");
            preparedStatement.setInt(3, 2);
            preparedStatement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            preparedStatement.setTimestamp(5, new Timestamp(System.currentTimeMillis()));

            preparedStatement.executeUpdate();
            ResultSet set = preparedStatement.executeQuery("select id from basics where id =60");
            //next有值证明已存在
            if (set.next()) {
                System.out.println("rollback");
                //回滚事务
                connection.rollback();
            } else {
                System.out.println("commit");
                //提交事务
                connection.commit();
            }
            System.out.println(connection.getTransactionIsolation());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection, preparedStatement);
        }
    }

    @Test
    //大文本处理
    public void insertBigText() {
        PreparedStatement preparedStatement = null;
        FileReader fileReader = null;
        try {
            preparedStatement = connection.prepareStatement("insert into text(text) values(?)");
//            preparedStatement.executeUpdate();
            //获取本类路径下的text文件路径，即text与本类同级
            String path = JdbcPreStatement2.class.getResource("text").getPath();

            //如果加上/，则代表根路径！所有的文件最后都会编译至out文件夹
//            String path = JdbcPreStatement2.class.getResource("/a.txt").getPath();
            File file = new File(path);
            fileReader = new FileReader(file);
            //大文本插入，用fileReader的输入流读取并插入
            preparedStatement.setCharacterStream(1, fileReader);
            int i = preparedStatement.executeUpdate();
            System.out.println(i);
        } catch (SQLException | FileNotFoundException e) {//捕获SQLException或者FileNotFoundException，因为对这两个异常的处理都是printStackTrace而已，所以可以写在一起
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            JdbcUtil.close(connection, preparedStatement);
        }
    }

    @Test
    //获取大文本
    public void getBigText() {
        PreparedStatement preparedStatement = null;
        //如果是在Finally中关闭，则此值必须要初始化
        Reader text = null;
        try {
            preparedStatement = connection.prepareStatement("select * from text where id = 1;");
            ResultSet set = preparedStatement.executeQuery();
            if (set.next()) {
                char[] chars = new char[1024];
                int length;
                //使用Reader流来读取大文本
                text = set.getCharacterStream("text");
                while ((length = text.read(chars)) != -1) {
                    System.out.print(new String(chars, 0, length));
                }
                System.out.println();
                System.out.println("******");
                //也可以直接用getString方式读取
                System.out.println(set.getString("text"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (text != null) {
                    text.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            JdbcUtil.close(connection, preparedStatement);
        }
    }

    @Test
    //存储二进制数据
    public void setBlob() {
        PreparedStatement preparedStatement = null;
        InputStream resourceAsStream = null;
        try {
            preparedStatement = connection.prepareStatement("insert into text(`binary`) values(?)");
            resourceAsStream = JdbcPreStatement2.class.getResourceAsStream("/test.png");
            preparedStatement.setBinaryStream(1, resourceAsStream);
            int i = preparedStatement.executeUpdate();
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resourceAsStream != null) {
                    resourceAsStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            JdbcUtil.close(connection, preparedStatement);
        }
    }

    @Test
    //获取二进制数据
    public void getBlob() {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select `binary` from text where id = 3");
            ResultSet set = preparedStatement.executeQuery();
            byte[] bytes = new byte[1024];
            int length;
            while (set.next()) {
                //获取输入流，读取blob内容
                InputStream binaryStream = set.getBinaryStream(1);
                //将blob内容写到png中
                OutputStream outputStream = new FileOutputStream("E:/test.png");
                while ((length = binaryStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, length);
                }
                outputStream.close();
                binaryStream.close();
            }
            System.out.println("done");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection, preparedStatement);
        }
    }
}
