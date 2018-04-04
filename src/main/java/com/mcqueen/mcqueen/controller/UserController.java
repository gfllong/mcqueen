package com.mcqueen.mcqueen.controller;

import com.mcqueen.mcqueen.base.McQueenBaseController;
import com.mcqueen.mcqueen.base.XaResult;
import com.mcqueen.mcqueen.base.util.CheckUtils;
import com.mcqueen.mcqueen.controller.vo.UserInfoVo;
import com.mcqueen.mcqueen.domain.UserDomain;
import com.mcqueen.mcqueen.model.UserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by gfl on 2018/4/4 15:26
 * Email:gfl@cheok.com.
 */
@Api(value = "user", description = "用户模块", position = 10)
@RestController
@RequestMapping("/user")
public class UserController extends McQueenBaseController {

    @Resource
    private UserDomain userDomain;

    @ApiOperation(value = "创建用户", notes = "添加用户使用")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public XaResult createUser(@ApiParam("手机号") String mobile,
                               @ApiParam("姓名") String name,
                               @ApiParam("密码") String pwd) {
        CheckUtils.checkStatus(StringUtils.isEmpty(mobile), "请输入手机号");
        CheckUtils.checkStatus(StringUtils.isEmpty(name), "请输入姓名");
        CheckUtils.checkStatus(StringUtils.isEmpty(pwd), "请输入密码");
        UserInfo userInfo = new UserInfo();
        userInfo.setMobile(mobile);
        userInfo.setName(name);
        userInfo.setPwd(pwd);
        this.userDomain.create(userInfo);
        return XaResult.success();
    }

    @ApiOperation(value = "修改用户", notes = "修改用户")
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public XaResult modifyUser(@ApiParam("手机号") String mobile,
                               @ApiParam("姓名") String name,
                               @ApiParam("密码") String pwd,
                               @ApiParam("用户ID") Integer userID) {
        CheckUtils.checkStatus(StringUtils.isEmpty(mobile), "请输入手机号");
        CheckUtils.checkStatus(StringUtils.isEmpty(name), "请输入手机号");
        CheckUtils.checkStatus(StringUtils.isEmpty(pwd), "请输入手机号");
        CheckUtils.checkStatus(userID == null, "用户不明确");
        //TODO
        return XaResult.success();
    }

    @ApiOperation(value = "禁用用户", notes = "禁用用户")
    @RequestMapping(value = "/forbidden", method = RequestMethod.POST)
    public XaResult forbiddenUser(@ApiParam("用户ID") Integer userID) {
        CheckUtils.checkStatus(userID == null, "用户不明确");
        //TODO
        return XaResult.success();
    }

    @ApiOperation(value = "用户配置角色", notes = "用户配置角色")
    @RequestMapping(value = "/config/role", method = RequestMethod.POST)
    public XaResult configUserRole(@ApiParam("用户ID") Integer userID, @ApiParam("用户ID") Integer[] roleIDList) {
        CheckUtils.checkStatus(userID == null, "用户不明确");
        CheckUtils.checkStatus(roleIDList == null || roleIDList.length == 0, "请选择分配的角色");
        //TODO
        return XaResult.success();
    }


    @ApiOperation(value = "用户登录校验账号密码", notes = "用户登录校验账号密码")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiResponse( code = 200, message = "Success", response = UserInfoVo.class, responseContainer = "Object" )
    public @ModelAttribute XaResult<UserInfoVo> loginUser(@ApiParam("手机号") String mobile,
                                          @ApiParam("密码") String pwd) {
        CheckUtils.checkStatus(StringUtils.isEmpty(mobile), "请输入手机号");
        CheckUtils.checkStatus(StringUtils.isEmpty(pwd), "请输入密码");
        //TODO
        return XaResult.success(new UserInfoVo());
    }

}
