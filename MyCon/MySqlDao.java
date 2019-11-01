package MyCon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//连接数据库进行操作
public class MySqlDao {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String driverName="com.mysql.jdbc.Driver";//驱动名称  mysql-connector-java 5不用cj.
        String url="jdbc:mysql://localhost:3306/teaching?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false";
        String userName="root";
        String password="5650656";
        Class.forName(driverName);//　Java加载数据库驱动的方法是调用Class类的静态方法forName
        Connection con= DriverManager.getConnection(url,userName,password);
        return con;
    }
}
