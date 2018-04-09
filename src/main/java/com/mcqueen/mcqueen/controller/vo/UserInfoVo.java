package com.mcqueen.mcqueen.controller.vo;


import com.mcqueen.mcqueen.model.UserInfo;
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
    private Integer userID;

    @ApiModelProperty("姓名")
    private String userName;

    @ApiModelProperty("是否启用")
    private Boolean isEnable;

    @ApiModelProperty("角色列表")
    private List<RoleInfoVo> roleInfoVos;

    @ApiModelProperty("权限列表")
    private List<AuthInfoVo> authInfoVos;

    public UserInfoVo() {
    }

    /**
     * 登录后返回
     *
     * @param userInfo
     * @param authInfoVos
     */
    public UserInfoVo(UserInfo userInfo, List<AuthInfoVo> authInfoVos) {
        if (userInfo != null) {
            this.userID = userInfo.getID();
            this.userName = userInfo.getName();
            this.isEnable = userInfo.getIsEnable();
        }
        this.authInfoVos = authInfoVos;
    }

    public UserInfoVo(UserInfo userInfo, List<RoleInfoVo> roleInfoVos, List<AuthInfoVo> authInfoVos) {
        if (userInfo != null) {
            this.userID = userInfo.getID();
            this.userName = userInfo.getName();
            this.isEnable = userInfo.getIsEnable();
        }
        this.roleInfoVos = roleInfoVos;
        this.authInfoVos = authInfoVos;
    }


    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
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

    public List<RoleInfoVo> getRoleInfoVos() {
        return roleInfoVos;
    }

    public void setRoleInfoVos(List<RoleInfoVo> roleInfoVos) {
        this.roleInfoVos = roleInfoVos;
    }

    public Boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
    }
}
