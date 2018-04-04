package com.mcqueen.mcqueen.controller;

import com.mcqueen.mcqueen.base.McQueenBaseController;
import com.mcqueen.mcqueen.base.XaResult;
import com.mcqueen.mcqueen.base.util.CheckUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gfl on 2018/4/4 16:40
 * Email:gfl@cheok.com.
 */

@Api(value = "role", description = "角色模块", position = 10)
@RestController
@RequestMapping("/role")
public class RoleController extends McQueenBaseController {


    @ApiOperation(value = "添加角色", notes = "添加角色")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public XaResult addRole(@ApiParam("角色名称") String roleName) {
        CheckUtils.checkStatus(StringUtils.isEmpty(roleName), "请输入角色名称");
        //TODO
        return XaResult.success();
    }


    @ApiOperation(value = "删除角色", notes = "删除角色")
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public XaResult delRole(@ApiParam("角色ID") Integer roleID) {
        CheckUtils.checkStatus(roleID == null, "请选择要删除的角色");
        //TODO
        return XaResult.success();
    }


    @ApiOperation(value = "角色配置权限", notes = "角色配置权限")
    @RequestMapping(value = "/config/auth", method = RequestMethod.POST)
    public XaResult configRoleAuth(@ApiParam(value="角色ID") Integer roleID, @ApiParam("权限ID列表") Integer[] authIDList) {
        CheckUtils.checkStatus(roleID == null, "请选择要删除的角色");
        //TODO
        return XaResult.success();
    }

}
