package com.mcqueen.mcqueen.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mcqueen.mcqueen.base.page.PageParam;
import com.mcqueen.mcqueen.mapper.AuthInfoMapper;
import com.mcqueen.mcqueen.model.AuthInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by gfl on 2018/4/8 10:51
 * Email:gfl@cheok.com.
 */
@Service
@Transactional(readOnly = false, rollbackFor = Exception.class)
public class AuthService {

    @Resource
    private AuthInfoMapper authInfoMapper;

    public void create(AuthInfo authInfo) {
        authInfo.setCreateTime(new Date());
        authInfo.setLastModifyTime(new Date());
        authInfo.setIsDelete(false);
        this.authInfoMapper.insertSelective(authInfo);
    }

    public void del(Integer authID) {
        AuthInfo authInfo = new AuthInfo();
        authInfo.setID(authID);
        authInfo.setLastModifyTime(new Date());
        authInfo.setIsDelete(true);
        this.authInfoMapper.updateByPrimaryKeySelective(authInfo);
    }

    public Page<AuthInfo> findAuth(PageParam pageParam) {
        PageHelper.startPage(pageParam.getCurrentPage(), pageParam.getPageSize());
        return this.authInfoMapper.findValidAuth();
    }

    public List<AuthInfo> findByUserID(Integer userID) {
        return this.authInfoMapper.findByUserID(userID);
    }

}
