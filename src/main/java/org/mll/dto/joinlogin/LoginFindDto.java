package org.mll.dto.joinlogin;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginFindDto {

    private String userId;
    private String userPass;
    private String userPass2;
    private String userName;
    private String searchUserId;

    private String findUserId;
    private String findUserPass;

    public String getFindUserId() {
        return findUserId;
    }

    public void setFindUserId(String findUserId) {
        this.findUserId = findUserId;
    }

    public String getFindUserPass() {
        return findUserPass;
    }

    public void setFindUserPass(String findUserPass) {
        this.findUserPass = findUserPass;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public void setUserPass2(String userPass2) {
        this.userPass2 = userPass2;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setSearchUserId(String searchUserId) {
        this.searchUserId = searchUserId;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPass() {
        return userPass;
    }

    public String getUserPass2() {
        return userPass2;
    }

    public String getUserName() {
        return userName;
    }

    public String getSearchUserId() {
        return searchUserId;
    }

}
