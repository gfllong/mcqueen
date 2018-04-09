package com.mcqueen.mcqueen.controller;

import com.mcqueen.mcqueen.base.McQueenBaseController;
import com.mcqueen.mcqueen.base.XaResult;
import com.mcqueen.mcqueen.base.page.PageInfo;
import com.mcqueen.mcqueen.base.page.PageParam;
import com.mcqueen.mcqueen.base.util.CheckUtils;
import com.mcqueen.mcqueen.controller.vo.RoleInfoVo;
import com.mcqueen.mcqueen.domain.RoleDomain;
import com.mcqueen.mcqueen.model.RoleInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gfl on 2018/4/4 16:40
 * Email:gfl@cheok.com.
 */

@Api(value = "role", description = "角色模块", position = 10)
@RestController
@RequestMapping("/mcqueen/role")
public class RoleController extends McQueenBaseController {


    @Resource
    private RoleDomain roleDomain;

    @ApiOperation(value = "添加角色", notes = "添加角色")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public XaResult addRole(@ApiParam("角色名称") String roleName) {
        CheckUtils.checkStatus(StringUtils.isEmpty(roleName), "请输入角色名称");
        this.roleDomain.create(roleName);
        return XaResult.success();
    }


    @ApiOperation(value = "删除角色", notes = "删除角色")
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public XaResult delRole(@ApiParam("角色ID") Integer roleID) {
        CheckUtils.checkStatus(roleID == null, "请选择要删除的角色");
        this.roleDomain.del(roleID);
        return XaResult.success();
    }

    @ApiOperation(value = "角色列表", notes = "角色列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public XaResult<List<RoleInfoVo>> findRoles(@ApiParam("当前页") Integer currentPage, @ApiParam("每页数量") Integer pageSize) {
        PageParam pageParam = new PageParam(currentPage, pageSize);
        PageInfo<RoleInfo> page = this.roleDomain.findRoles(pageParam);
        List<RoleInfoVo> roleInfoVos = null;
        List<RoleInfo> roleInfos = null;
        if (page != null) {
            roleInfos = page.getList();

        }
        roleInfoVos = RoleInfoVo.convertList(roleInfos);
        return XaResult.success(page, roleInfoVos);
    }

    @ApiOperation(value = "角色配置权限", notes = "角色配置权限")
    @RequestMapping(value = "/config/auth", method = RequestMethod.POST)
    public XaResult configRoleAuth(@ApiParam(value = "角色ID") Integer roleID, @ApiParam("权限ID列表") Integer[] authIDList) {
        CheckUtils.checkStatus(roleID == null, "请选择要分配权限的角色");
        CheckUtils.checkStatus(authIDList == null || authIDList.length == 0, "请选择分配的权限");
        this.roleDomain.roleConfigAuth(roleID, authIDList);
        return XaResult.success();
    }

}
