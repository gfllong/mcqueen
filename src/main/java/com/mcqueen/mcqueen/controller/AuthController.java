package com.mcqueen.mcqueen.controller;

import com.mcqueen.mcqueen.base.McQueenBaseController;
import com.mcqueen.mcqueen.base.XaResult;
import com.mcqueen.mcqueen.base.util.CheckUtils;
import com.mcqueen.mcqueen.controller.vo.UserInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gfl on 2018/4/4 16:35
 * Email:gfl@cheok.com.
 */
@Api(value = "auth", description = "权限模块", position = 10)
@RestController
@RequestMapping("/auth")
public class AuthController extends McQueenBaseController{

    @ApiOperation(value = "添加权限", notes = "添加权限")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public XaResult addAuth(@ApiParam("权限名") String authName,
                            @ApiParam("权限类型（100:接口请求，200:页面路径）") Integer authType,
                            @ApiParam("路径") String path) {
        CheckUtils.checkStatus(StringUtils.isEmpty(authName), "请输入权限名称");
        CheckUtils.checkStatus(StringUtils.isEmpty(path), "请输入path");
        CheckUtils.checkStatus(authType == null, "请选择权限控制类型接口请求或页面路径");
        //TODO
        return XaResult.success();
    }

    @ApiOperation(value = "删除权限", notes = "删除权限")
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public XaResult delAuth(@ApiParam("权限ID") Integer authID) {
        CheckUtils.checkStatus(authID == null, "请选择需要删除的权限");
        //TODO
        return XaResult.success();
    }


}
