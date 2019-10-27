package JDBC;

import java.sql.*;

public class DBTest2 {
    public void test2() throws ClassNotFoundException, SQLException {
        String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";//SQL Server驱动名称
        String url="jdbc:sqlserver://192.168.0.104:1433;DatabaseName=teaching";
        //JDK为1.6以下的jdbc连接的jar使用sqljdbc.jar,以上使用sqljdbc4.jar
        String userName="sa";
        String password="5650656";
        Class.forName(driverName);//　Java加载数据库驱动的方法是调用Class类的静态方法forName
        Connection connection= DriverManager.getConnection(url,userName,password);
        //DriverManager注册驱动 getConnection是DriverManager里面的方法
        //对数据库进行创建，插入
        String sql1="CREATE TABLE student2(sno INT PRIMARY KEY ,sname char(20) NOT NULL)";//建表student2，设置sno,sname
        String sql2="INSERT INTO student2 VALUES(201707771,'陆瑶')";//建表student2，设置sno,sname
        Statement statement=connection.createStatement();//获取Statement对象
        statement.execute(sql1);
        statement.execute(sql2);

        System.out.println("处理完毕！");

        statement.close();
    }
}
