package com.mcqueen.mcqueen.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mcqueen.mcqueen.base.page.PageParam;
import com.mcqueen.mcqueen.mapper.UserInfoMapper;
import com.mcqueen.mcqueen.mapper.UserRoleMapper;
import com.mcqueen.mcqueen.model.UserInfo;
import com.mcqueen.mcqueen.model.UserInfoExample;
import com.mcqueen.mcqueen.model.UserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by gfl on 2018/4/4 16:50
 * Email:gfl@cheok.com.
 */
@Service
@Transactional(readOnly = false, rollbackFor = Exception.class)
public class UserService {

    @Resource
    private UserInfoMapper userInfoMapper;
    @Resource
    private UserRoleMapper userRoleMapper;

    public void create(UserInfo userInfo) {
        userInfo.setCreateTime(new Date());
        userInfo.setIsDelete(false);
        userInfo.setLastModifyTime(new Date());
        userInfo.setIsEnable(true);
        this.userInfoMapper.insertSelective(userInfo);
    }


    public void modify(UserInfo userInfo) {
        userInfo.setLastModifyTime(new Date());
        this.userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    public void forbidden(Integer userID) {
        UserInfo userInfo = new UserInfo();
        userInfo.setID(userID);
        userInfo.setIsEnable(false);
        userInfo.setLastModifyTime(new Date());
        this.userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }


    public UserInfo getByMobile(String mobile) {
        UserInfoExample example = new UserInfoExample();
        UserInfoExample.Criteria criteria = example.createCriteria();
        criteria.andMobileEqualTo(mobile);
        criteria.andIsDeleteEqualTo(false);
        List<UserInfo> userInfos = this.userInfoMapper.selectByExample(example);
        return userInfos != null && userInfos.size() > 0 ? userInfos.get(0) : null;
    }


    public UserInfo getByMobileAndPwd(String mobile, String pwd) {
        UserInfoExample example = new UserInfoExample();
        UserInfoExample.Criteria criteria = example.createCriteria();
        criteria.andMobileEqualTo(mobile);
        criteria.andPwdEqualTo(pwd);
        criteria.andIsDeleteEqualTo(false);
        criteria.andIsEnableEqualTo(true);
        List<UserInfo> userInfos = this.userInfoMapper.selectByExample(example);
        return userInfos != null && userInfos.size() > 0 ? userInfos.get(0) : null;
    }

    public Page<UserInfo> findUsers(PageParam pageParam) {
        PageHelper.startPage(pageParam.getCurrentPage(), pageParam.getPageSize());
        return this.userInfoMapper.findUsers();
    }

    public void configUserRole(List<UserRole> userRoles) {
        this.userRoleMapper.configUserRole(userRoles);
    }

    public void delAllRoleByUserID(Integer userID) {
        this.userRoleMapper.delAllRoleByUserID(userID);
    }
}
