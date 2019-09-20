package db;

import java.sql.*;

//负责连接和关闭数据库
public class DBManager {
    private DBManager(){

    }

    /**
     * 这个能够获取到数据库的连接
     * user:root
     * passwd:root
     * 数据库：db1
     * @return
     */
    public static Connection getConnection(){
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url ="jdbc:mysql://localhost:3306/db1?characterEncoding=utf8&useSSL=false?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
            String user = "root";
            String password = "root";
            conn = DriverManager.getConnection(url,user,password);
        }catch(ClassNotFoundException e){
            System.out.println("未找到类！");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void close(Connection conn, PreparedStatement ps, ResultSet rs){
       try{
           if (rs!=null){
               rs.close();
           }
           ps.close();
           conn.close();
       }catch(SQLException e){
           System.out.println(e.getMessage());
       }
    }
}
