package com.mcqueen.mcqueen.controller.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by gfl on 2018/4/4 16:31
 * Email:gfl@cheok.com.
 */
@ApiModel(value = "AuthInfoVo", description = "权限对象")
public class AuthInfoVo {

    @ApiModelProperty("权限")
    private String authName;


    @ApiModelProperty("权限类型（100:接口请求，200:页面路径）")
    private Integer authType;


    @ApiModelProperty("路径")
    private String path;

    public AuthInfoVo() {
    }

    public AuthInfoVo(String authName, Integer authType, String path) {
        this.authName = authName;
        this.authType = authType;
        this.path = path;
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
}
