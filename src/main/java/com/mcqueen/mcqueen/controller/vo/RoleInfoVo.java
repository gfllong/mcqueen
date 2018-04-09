package com.mcqueen.mcqueen.controller.vo;

import com.mcqueen.mcqueen.model.RoleInfo;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gfl on 2018/4/8 16:08
 * Email:gfl@cheok.com.
 */
public class RoleInfoVo {

    @ApiModelProperty("角色ID")
    private Integer roleID;

    @ApiModelProperty("角色名称")
    private String roleName;

    public RoleInfoVo() {
    }

    public RoleInfoVo(RoleInfo roleInfo) {
        if (roleInfo != null) {
            this.roleID = roleInfo.getID();
            this.roleName = roleInfo.getRoleName();
        }
    }

    public static List<RoleInfoVo> convertList(List<RoleInfo> roleInfos) {
        List<RoleInfoVo> roleInfoVos = null;
        if (roleInfos != null && roleInfos.size() > 0) {
            roleInfoVos = new ArrayList<>();
            for (RoleInfo roleInfo : roleInfos) {
                roleInfoVos.add(new RoleInfoVo(roleInfo));
            }

        }
        return roleInfoVos;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
