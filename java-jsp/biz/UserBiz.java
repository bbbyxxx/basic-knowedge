package biz;

import bean.UserInfo;
import dao.UserInfoDAO;

import java.util.List;

public class UserBiz {
    private UserInfoDAO uidao = new UserInfoDAO();

    public List<UserInfo>  findAllUser(){
        return uidao.selectAll();
    }
}
