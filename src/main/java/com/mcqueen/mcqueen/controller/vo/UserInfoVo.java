package com.mcqueen.mcqueen.controller.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by gfl on 2018/4/4 16:30
 * Email:gfl@cheok.com.
 */
@ApiModel(value = "UserInfoVo", description = "用户对象")
public class UserInfoVo {

    @ApiModelProperty("ID")
    private String userID;

    @ApiModelProperty("姓名")
    private String userName;

    @ApiModelProperty("权限列表")
    private List<AuthInfoVo> authInfoVos;

    public UserInfoVo() {
    }

    public UserInfoVo(String userID, String userName, List<AuthInfoVo> authInfoVos) {
        this.userID = userID;
        this.userName = userName;
        this.authInfoVos = authInfoVos;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<AuthInfoVo> getAuthInfoVos() {
        return authInfoVos;
    }

    public void setAuthInfoVos(List<AuthInfoVo> authInfoVos) {
        this.authInfoVos = authInfoVos;
    }
}
