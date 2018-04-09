package com.mcqueen.mcqueen.base.page;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by gfl on 2018/4/8 11:27
 * Email:gfl@cheok.com.
 */
public class PageParam {

    @ApiModelProperty("当前页")
    private Integer currentPage;

    @ApiModelProperty("每页大小")
    private Integer pageSize;

    public PageParam() {
    }

    public PageParam(Integer currentPage, Integer pageSize) {
        this.currentPage = currentPage == null ? 1 : currentPage;
        this.pageSize = pageSize == null || pageSize > 50 ? 20 : pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
