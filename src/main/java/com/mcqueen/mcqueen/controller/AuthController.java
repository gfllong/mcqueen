package com.mcqueen.mcqueen.controller;

import com.mcqueen.mcqueen.base.McQueenBaseController;
import com.mcqueen.mcqueen.base.XaResult;
import com.mcqueen.mcqueen.base.page.PageInfo;
import com.mcqueen.mcqueen.base.page.PageParam;
import com.mcqueen.mcqueen.base.util.CheckUtils;
import com.mcqueen.mcqueen.controller.vo.AuthInfoVo;
import com.mcqueen.mcqueen.controller.vo.UserInfoVo;
import com.mcqueen.mcqueen.domain.AuthDomain;
import com.mcqueen.mcqueen.enums.AuthType;
import com.mcqueen.mcqueen.model.AuthInfo;
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
 * Created by gfl on 2018/4/4 16:35
 * Email:gfl@cheok.com.
 */
@Api(value = "auth", description = "权限模块", position = 10)
@RestController
@RequestMapping("/mcqueen/auth")
public class AuthController extends McQueenBaseController {

    @Resource
    private AuthDomain authDomain;

    @ApiOperation(value = "添加权限", notes = "添加权限")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public XaResult addAuth(@ApiParam("权限名") String authName,
                            @ApiParam("权限类型（100:接口请求，200:页面路径）") Integer authType,
                            @ApiParam("路径") String path) {
        CheckUtils.checkStatus(StringUtils.isEmpty(authName), "请输入权限名称");
        CheckUtils.checkStatus(StringUtils.isEmpty(path), "请输入path");
        CheckUtils.checkStatus(authType == null, "请选择权限控制类型接口请求或页面路径");
        this.authDomain.create(authName, AuthType.getByValue(authType), path);
        return XaResult.success();
    }

    @ApiOperation(value = "删除权限", notes = "删除权限")
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public XaResult delAuth(@ApiParam("权限ID") Integer authID) {
        CheckUtils.checkStatus(authID == null, "请选择需要删除的权限");
        this.authDomain.del(authID);
        return XaResult.success();
    }

    @ApiOperation(value = "权限列表", notes = "权限列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public XaResult<List<AuthInfoVo>> findAuth(@ApiParam("当前页") Integer currentPage, @ApiParam("每页数量") Integer pageSize) {
        PageParam pageParam = new PageParam(currentPage, pageSize);
        PageInfo<AuthInfo> page = this.authDomain.findAuth(pageParam);
        List<AuthInfo> authInfos = null;
        if (page != null) {
            authInfos = page.getList();

        }
        List<AuthInfoVo> authInfoVos = AuthInfoVo.convertList(authInfos);
        return XaResult.success(page, authInfoVos);
    }


}
