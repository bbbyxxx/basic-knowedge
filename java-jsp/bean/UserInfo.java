package bean;

import org.omg.CORBA.PRIVATE_MEMBER;

public class UserInfo {
    private Integer userId;
    private String userName;
    private Integer userAge;
    private String userSex;
    private String userAddress;
    private String userPass;
    private Integer userState;

    public UserInfo(){

    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public String getUserSex() {
        return userSex;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public String getUserPass() {
        return userPass;
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }
}


