package com.mcqueen.mcqueen.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mcqueen.mcqueen.base.page.PageInfo;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gfl on 2018/4/4 15:33
 * Email:gfl@cheok.com.
 */
public class XaResult<T> implements Serializable {
    private static final long serialVersionUID = -4000911896921132227L;


    @ApiModelProperty("code : 返回代码，1表示OK，其它的都有对应问题   9表示 未登陆")
    private int code = 1;

    @ApiModelProperty("message : 如果code!=1,错误信息")
    private String message = "成功!";

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty("code为1时返回结果集")
    private T object = null;

    @ApiModelProperty("附加信息")
    private Map<String, Object> map = new HashMap();

    @ApiModelProperty("分页信息")
    private PageInfo page;


    public XaResult() {
        super();
    }

    public void setError(String message) {
        this.code = 0;
        this.message = message;
        this.object = null;
        this.map = new HashMap();
    }

    public void setSuccess(T object) {
        this.code = 1;
        this.message = "成功!";
        this.object = object;
        this.map = new HashMap();
    }

    public void setSuccess() {
        this.code = 1;
        this.message = "成功!";
    }

    public XaResult(String errorMsg) {
        this.message = errorMsg;
        this.code = 0;
        this.object = null;
        this.map = new HashMap();
    }

    public static <K> XaResult<List<K>> success(PageInfo page) {
        XaResult xaResult = new XaResult();
        xaResult.setSuccess(page.getList());
        xaResult.setPage(page);
        return xaResult;
    }
    public static <K> XaResult<List<K>> success(PageInfo page, List<K> contents) {
        XaResult xaResult = new XaResult();
        xaResult.setSuccess(contents);
        xaResult.setPage(page);
        return xaResult;
    }

    public static <R> XaResult<R> error(String message) {
        XaResult xaResult = new XaResult();
        xaResult.setError(message == null ? "网络不给力" : message);
        return xaResult;
    }


    public static <R> XaResult<R> success() {
        XaResult xaResult = new XaResult();
        xaResult.setSuccess();
        return xaResult;
    }

    public static <R> XaResult<R> success(R object) {
        XaResult xaResult = new XaResult();
        xaResult.setSuccess(object);
        return xaResult;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public PageInfo getPage() {
        return page;
    }

    public void setPage(PageInfo page) {
        page.setList(null);
        this.page = page;
    }
}
