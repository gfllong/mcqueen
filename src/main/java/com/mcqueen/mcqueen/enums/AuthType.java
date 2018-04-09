package com.mcqueen.mcqueen.enums;

/**
 * Created by gfl on 2018/4/8 10:53
 * Email:gfl@cheok.com.
 */
public enum AuthType {
    api("接口请求", 100),
    page("页面路径", 200);

    private Integer value;
    private String content;


    private AuthType(String content, Integer value) {
        this.content = content;
        this.value = value;
    }

    public static AuthType getByValue(Integer value) {
        AuthType[] types = AuthType.values();
        for (AuthType type : types) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        return null;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
