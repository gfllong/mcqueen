package com.mcqueen.mcqueen.controller.vo;


import com.mcqueen.mcqueen.model.AuthInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gfl on 2018/4/4 16:31
 * Email:gfl@cheok.com.
 */
@ApiModel(value = "AuthInfoVo", description = "权限对象")
public class AuthInfoVo {


    @ApiModelProperty("权限ID")
    private Integer authID;


    @ApiModelProperty("权限")
    private String authName;


    @ApiModelProperty("权限类型（100:接口请求，200:页面路径）")
    private Integer authType;


    @ApiModelProperty("路径")
    private String path;

    public AuthInfoVo() {
    }


    public AuthInfoVo(AuthInfo authInfo) {
        if (authInfo != null) {
            this.authName = authInfo.getAuthName();
            this.authType = authInfo.getAuthType();
            this.path = authInfo.getPath();
            this.authID = authInfo.getID();
        }
    }

    public static List<AuthInfoVo> convertList(List<AuthInfo> authInfos) {
        List<AuthInfoVo> authInfoVos = null;
        if (authInfos != null && authInfos.size() > 0) {
            authInfoVos = new ArrayList<>();
            for (AuthInfo authInfo : authInfos) {
                authInfoVos.add(new AuthInfoVo(authInfo));
            }
        }
        return authInfoVos;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public Integer getAuthType() {
        return authType;
    }

    public void setAuthType(Integer authType) {
        this.authType = authType;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getAuthID() {
        return authID;
    }

    public void setAuthID(Integer authID) {
        this.authID = authID;
    }
}
