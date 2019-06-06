package com.bishe.demo.common.util.Response;

public enum  ResponseCode {

    SUCCESS(0, "成功"),
    ERROR(1, "错误"),
    NEED_LOGIN(10, "未登陆,请登陆后再操作"),
    NO_PERMISSION(11,"当前用户没有该操作权限"),
    ILLEGAL_ARGUMENT(2, "参数错误");

    private final int code;
    private final String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
