package com.mcqueen.mcqueen.service;

import com.mcqueen.mcqueen.mapper.UserInfoMapper;
import com.mcqueen.mcqueen.model.UserInfo;
import com.mcqueen.mcqueen.model.UserInfoExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by gfl on 2018/4/4 16:50
 * Email:gfl@cheok.com.
 */
@Service
public class UserService {

    @Resource
    private UserInfoMapper userInfoMapper;

    public void create(UserInfo userInfo) {
        userInfo.setCreateTime(new Date());
        userInfo.setIsDelete(false);
        userInfo.setLastModifyTime(new Date());
        this.userInfoMapper.insertSelective(userInfo);
    }

    public UserInfo getByMobile(String mobile) {
        UserInfoExample example = new UserInfoExample();
        UserInfoExample.Criteria criteria = example.createCriteria();
        criteria.andMobileEqualTo(mobile);
        criteria.andIsDeleteEqualTo(false);
        List<UserInfo> userInfos = this.userInfoMapper.selectByExample(example);
        return userInfos != null && userInfos.size() > 0 ? userInfos.get(0) : null;
    }
}
