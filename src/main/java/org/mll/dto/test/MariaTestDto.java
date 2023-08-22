package org.mll.dto.test;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MariaTestDto {

    private String userId;
    private String userPass;
    private String userPass2;
    private String userName;
    private String searchUserId;

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
