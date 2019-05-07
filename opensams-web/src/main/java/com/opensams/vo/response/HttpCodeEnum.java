package com.opensams.vo.response;

/**
 * @author Kevin Leung
 */
public enum HttpCodeEnum {
    // 成功
    SUCCESS("200"),
    // 发送异常
    ERROR("500"),
    // 无操作权限
    NO_PERMISSION("403"),
    // 重定向
    REDIRECT("302");

    private String statusCode;

    HttpCodeEnum(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusCode() {
        return statusCode;
    }
}
