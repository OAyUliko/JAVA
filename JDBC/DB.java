package JDBC;


import java.sql.SQLException;
import java.util.Scanner;

public class DB {
    public static void  main(String[] args) throws SQLException, ClassNotFoundException {
        DBTest dbt=new DBTest();
        DBTest2 dbt2=new DBTest2();
        Scanner sc=new Scanner(System.in);
        System.out.println("请选择要执行的数据库：1.MySQL      2.SQL Server");
        int db=sc.nextInt();
        if(db==1)
            dbt.test();
        else
            dbt2.test2();
    }
}
