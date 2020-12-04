package org.example.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.example.exception.AppException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xuwenqing
 * Date: 2020-12-03
 * Time: 20:15:05
 */
public class DButil {

    private static final DataSource DS = new MysqlDataSource();

    //多线程学习以后，会优化为双重校验锁的单例模式来使用DataSource
    static {
        ((MysqlDataSource)DS).setUrl("jdbc:mysql://localhost:3306/chong_blog?user=root&password=123&useUnicode=true&useSSL=false&characterEncoding=UTF-8");

    }

    public static Connection getConnection(){//获取数据库连接的操作
        try {
            return DS.getConnection();
        } catch (SQLException e) {
            throw new AppException("DB001","获取数据库连接失败",e);
        }
    }


    public static void close(Connection c, Statement s){//释放资源的操作
        close(c,s,null);
    }

    public static void close(Connection c, Statement s, ResultSet r){//释放资源的操作
        try {
            if (r != null){
                r.close();
            }
            if (s != null){
                s.close();
            }
            if (c != null){
                c.close();
            }
        } catch (SQLException e) {
            throw new AppException("DB002","释放数据库资源失败",e);
        }
    }
}
