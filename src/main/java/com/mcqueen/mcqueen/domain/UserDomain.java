package com.mcqueen.mcqueen.domain;

import com.github.pagehelper.Page;
import com.mcqueen.mcqueen.base.McQueenException;
import com.mcqueen.mcqueen.base.page.PageInfo;
import com.mcqueen.mcqueen.base.page.PageParam;
import com.mcqueen.mcqueen.base.util.CheckUtils;
import com.mcqueen.mcqueen.controller.vo.UserInfoVo;
import com.mcqueen.mcqueen.model.RoleInfo;
import com.mcqueen.mcqueen.model.UserInfo;
import com.mcqueen.mcqueen.model.UserRole;
import com.mcqueen.mcqueen.service.RoleService;
import com.mcqueen.mcqueen.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by gfl on 2018/4/4 16:52
 * Email:gfl@cheok.com.
 */
@Service
@Transactional(readOnly = false, rollbackFor = Exception.class)
public class UserDomain {

    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;


    /**
     * 创建用户
     *
     * @param userInfo
     * @throws McQueenException
     */
    public void create(UserInfo userInfo) throws McQueenException {
        CheckUtils.checkStatus(userInfo == null, "用户信息不能为空");
        CheckUtils.checkStatus(StringUtils.isEmpty(userInfo.getMobile()), "请输入手机号");
        CheckUtils.checkStatus(StringUtils.isEmpty(userInfo.getName()), "请输入姓名");
        CheckUtils.checkStatus(StringUtils.isEmpty(userInfo.getPwd()), "请输入密码");
        UserInfo oldUser = this.userService.getByMobile(userInfo.getMobile());
        CheckUtils.checkStatus(oldUser != null, "用户已存在");
        this.userService.create(userInfo);
    }


    /**
     * 修改用户
     *
     * @param userInfo
     * @throws McQueenException
     */
    public void modify(UserInfo userInfo) throws McQueenException {
        CheckUtils.checkStatus(userInfo == null, "用户信息不能为空");
        CheckUtils.checkStatus(userInfo.getID() == null, "用户信息不能为空");
        this.userService.modify(userInfo);
    }


    /**
     * 禁用用户
     *
     * @param userID
     * @throws McQueenException
     */
    public void forbidden(Integer userID) throws McQueenException {
        CheckUtils.checkStatus(userID == null, "用户信息不能为空");
        this.userService.forbidden(userID);
    }


    /**
     * 登录
     *
     * @param mobile
     * @param pwd
     * @return
     * @throws McQueenException
     */
    public UserInfo login(String mobile, String pwd) throws McQueenException {
        CheckUtils.checkStatus(StringUtils.isEmpty(mobile), "请输入账号");
        CheckUtils.checkStatus(StringUtils.isEmpty(pwd), "请输入密码");
        return this.userService.getByMobileAndPwd(mobile, pwd);
    }

    public PageInfo<UserInfo> findUsers(PageParam pageParam) throws McQueenException {
        Page<UserInfo> userInfos = this.userService.findUsers(pageParam);
        PageInfo<UserInfo> pageInfo = new PageInfo<>(userInfos);
        return pageInfo;
    }

    public void configUserRole(Integer userID, Integer[] roleIDList) throws McQueenException {
        CheckUtils.checkStatus(userID == null, "用户不明确");
        CheckUtils.checkStatus(roleIDList == null || roleIDList.length == 0, "请选择分配的角色");
        List<UserRole> userRoles = new ArrayList<>();
        for (Integer roleID : roleIDList) {
            UserRole userRole = new UserRole();
            userRole.setUserID(userID);
            userRole.setRoleID(roleID);
            userRole.setCreateTime(new Date());
            userRole.setLastModifyTime(new Date());
            userRole.setIsDelete(false);
            userRoles.add(userRole);
        }
        this.userService.delAllRoleByUserID(userID);
        this.userService.configUserRole(userRoles);
    }

    public void delAllRoleByUserID(Integer userID) throws McQueenException {
        this.userService.delAllRoleByUserID(userID);
    }


}
