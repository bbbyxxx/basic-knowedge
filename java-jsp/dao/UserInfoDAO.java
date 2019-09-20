package dao;

import bean.UserInfo;
import db.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserInfoDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    public List<UserInfo> selectAll(){
        List<UserInfo> list = new ArrayList<>();
        String sql = "select * from userinfo where userstate=1";
        conn = DBManager.getConnection();
        try{
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                UserInfo ui = new UserInfo();
                ui.setUserId(rs.getInt(1));
                ui.setUserName(rs.getString(2));
                ui.setUserSex(rs.getString(3));
                ui.setUserAge(rs.getInt(4));
                ui.setUserAddress(rs.getString(5));
                ui.setUserPass(rs.getString(6));
                ui.setUserState(rs.getInt(7));
                list.add(ui);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }
}
