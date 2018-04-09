package com.mcqueen.mcqueen.domain;

import com.github.pagehelper.Page;
import com.mcqueen.mcqueen.base.McQueenException;
import com.mcqueen.mcqueen.base.page.PageInfo;
import com.mcqueen.mcqueen.base.page.PageParam;
import com.mcqueen.mcqueen.base.util.CheckUtils;
import com.mcqueen.mcqueen.enums.AuthType;
import com.mcqueen.mcqueen.model.AuthInfo;
import com.mcqueen.mcqueen.service.AuthService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gfl on 2018/4/8 10:50
 * Email:gfl@cheok.com.
 */
@Service
@Transactional(readOnly = false, rollbackFor = Exception.class)
public class AuthDomain {

    @Resource
    private AuthService authService;


    /**
     * 创建权限
     *
     * @param authName
     * @param authType
     * @param path
     * @throws McQueenException
     */
    public void create(String authName, AuthType authType, String path) throws McQueenException {
        CheckUtils.checkStatus(StringUtils.isEmpty(authName), "请输入权限名称");
        CheckUtils.checkStatus(StringUtils.isEmpty(path), "请输入path");
        CheckUtils.checkStatus(authType == null, "请选择权限控制类型接口请求或页面路径");
        AuthInfo authInfo = new AuthInfo();
        authInfo.setAuthName(authName);
        authInfo.setAuthType(authType.getValue());
        authInfo.setPath(path);
        this.authService.create(authInfo);
    }


    /**
     * 删除权限
     *
     * @param authID
     */
    public void del(Integer authID) {
        CheckUtils.checkStatus(authID == null, "请选择要删除的权限");
        this.authService.del(authID);
    }


    /**
     * 权限列表
     *
     * @param pageParam
     * @return
     */
    public PageInfo<AuthInfo> findAuth(PageParam pageParam) {
        Page<AuthInfo> authInfos = this.authService.findAuth(pageParam);
        PageInfo<AuthInfo> pageInfo = new PageInfo<>(authInfos);
        return pageInfo;
    }

    public List<AuthInfo> findByUserID(Integer userID) {
        return this.authService.findByUserID(userID);
    }

}
