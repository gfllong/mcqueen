package com.mcqueen.mcqueen.domain;

import com.github.pagehelper.Page;
import com.mcqueen.mcqueen.base.McQueenException;
import com.mcqueen.mcqueen.base.page.PageInfo;
import com.mcqueen.mcqueen.base.page.PageParam;
import com.mcqueen.mcqueen.base.util.CheckUtils;
import com.mcqueen.mcqueen.model.RoleAuth;
import com.mcqueen.mcqueen.model.RoleInfo;
import com.mcqueen.mcqueen.service.RoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by gfl on 2018/4/8 13:35
 * Email:gfl@cheok.com.
 */
@Service
@Transactional(readOnly = false, rollbackFor = Exception.class)
public class RoleDomain {


    @Resource
    private RoleService roleService;


    /**
     * 创建角色
     *
     * @param roleName
     */
    public void create(String roleName) throws McQueenException {
        CheckUtils.checkStatus(StringUtils.isEmpty(roleName), "请输入角色名称");
        RoleInfo roleInfo = new RoleInfo();
        roleInfo.setRoleName(roleName);
        this.roleService.create(roleInfo);
    }


    /**
     * 删除角色
     *
     * @param roleID
     * @throws McQueenException
     */
    public void del(Integer roleID) throws McQueenException {
        this.roleService.del(roleID);
    }

    public PageInfo<RoleInfo> findRoles(PageParam pageParam) {
        Page<RoleInfo> roleInfos = this.roleService.findRoles(pageParam);
        PageInfo<RoleInfo> pageInfo = new PageInfo<>(roleInfos);
        return pageInfo;
    }

    public void roleConfigAuth(Integer roleID, Integer[] authIDList) {
        CheckUtils.checkStatus(roleID == null, "请选择要分配权限的角色");
        CheckUtils.checkStatus(authIDList == null || authIDList.length == 0, "请选择分配的权限");
        List<RoleAuth> roleAuthList = new ArrayList<>();
        for (Integer authID : authIDList) {
            RoleAuth roleAuth = new RoleAuth();
            roleAuth.setRoleID(roleID);
            roleAuth.setAuthID(authID);
            roleAuth.setCreateTime(new Date());
            roleAuth.setLastModifyTime(new Date());
            roleAuth.setIsDelete(false);
            roleAuthList.add(roleAuth);
        }
        this.roleService.delAllAuthByRoleID(roleID);
        this.roleService.roleConfigAuth(roleAuthList);
    }


    public List<RoleInfo> findByUserID(Integer userID) {
        return this.roleService.findByUserID(userID);
    }

    public void delAllAuthByRoleID(Integer roleID) {
        this.roleService.delAllAuthByRoleID(roleID);
    }

}
