package com.mcqueen.mcqueen.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mcqueen.mcqueen.base.McQueenException;
import com.mcqueen.mcqueen.base.page.PageParam;
import com.mcqueen.mcqueen.mapper.RoleAuthMapper;
import com.mcqueen.mcqueen.mapper.RoleInfoMapper;
import com.mcqueen.mcqueen.model.RoleAuth;
import com.mcqueen.mcqueen.model.RoleInfo;
import com.mcqueen.mcqueen.model.RoleInfoExample;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by gfl on 2018/4/8 13:36
 * Email:gfl@cheok.com.
 */
@Service
@Transactional(readOnly = false, rollbackFor = Exception.class)
public class RoleService {

    @Resource
    private RoleInfoMapper roleInfoMapper;
    @Resource
    private RoleAuthMapper roleAuthMapper;

    public void create(RoleInfo roleInfo) {
        roleInfo.setCreateTime(new Date());
        roleInfo.setLastModifyTime(new Date());
        roleInfo.setIsDelete(false);
        this.roleInfoMapper.insertSelective(roleInfo);
    }


    public void del(Integer roleID) {
        RoleInfo roleInfo = new RoleInfo();
        roleInfo.setID(roleID);
        roleInfo.setIsDelete(true);
        roleInfo.setLastModifyTime(new Date());
        this.roleInfoMapper.updateByPrimaryKeySelective(roleInfo);
    }


    public Page<RoleInfo> findRoles(PageParam pageParam) {
        PageHelper.startPage(pageParam.getCurrentPage(), pageParam.getPageSize());
        return this.roleInfoMapper.findValidRoles();
    }

    public void roleConfigAuth(List<RoleAuth> roleAuthList) {
        this.roleAuthMapper.roleConfigAuth(roleAuthList);
    }

    public List<RoleInfo> findByUserID(Integer userID) {
        return this.roleInfoMapper.findByUserID(userID);
    }

    public void delAllAuthByRoleID(Integer roleID){
        this.roleAuthMapper.delAllAuthByRoleID(roleID);
    }




}
