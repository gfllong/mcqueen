package com.mcqueen.mcqueen.domain;

import com.mcqueen.mcqueen.base.util.CheckUtils;
import com.mcqueen.mcqueen.model.UserInfo;
import com.mcqueen.mcqueen.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by gfl on 2018/4/4 16:52
 * Email:gfl@cheok.com.
 */
@Service
public class UserDomain {

    @Resource
    private UserService userService;

    public void create(UserInfo userInfo) {
        CheckUtils.checkStatus(userInfo == null, "用户信息不能为空");
        CheckUtils.checkStatus(StringUtils.isEmpty(userInfo.getMobile()), "请输入手机号");
        CheckUtils.checkStatus(StringUtils.isEmpty(userInfo.getName()), "请输入姓名");
        CheckUtils.checkStatus(StringUtils.isEmpty(userInfo.getPwd()), "请输入密码");
        UserInfo oldUser = this.userService.getByMobile(userInfo.getMobile());
        CheckUtils.checkStatus(oldUser != null, "用户已存在");
        this.userService.create(userInfo);
    }


}
