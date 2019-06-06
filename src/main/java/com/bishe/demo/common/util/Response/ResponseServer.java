package com.bishe.demo.common.util.Response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseServer<T> implements Serializable {
    private int status;
    private String msg;
    private T data;

    private ResponseServer(int status) {
        this.status = status;
    }

    private ResponseServer(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ResponseServer(String msg, T data) {
        this.msg = msg;
        this.data = data;
    }

    private ResponseServer(int status, T data) {
        this.status = status;
        this.data = data;
    }

    private ResponseServer(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public boolean isSuccess() {
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    // ↓↓ success
    public static <T> ResponseServer<T> createBySuccess() {
        return new ResponseServer<>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ResponseServer<T> createBySuccessMsg(String msg) {
        return new ResponseServer<>(ResponseCode.SUCCESS.getCode(), msg);
    }

    public static <T> ResponseServer<T> createBySuccess(T data) {
        return new ResponseServer<T>(ResponseCode.SUCCESS.getCode(), data);
    }

    public static <T> ResponseServer<T> createBySuccess(String msg, T data) {
        return new ResponseServer<T>(ResponseCode.SUCCESS.getCode(), msg, data);
    }

    // ↓↓ error
    public static <T> ResponseServer<T> createByError() {
        return new ResponseServer<T>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
    }

    public static <T> ResponseServer<T> createByErrorMsg(String errorMessage) {
        return new ResponseServer<T>(ResponseCode.ERROR.getCode(), errorMessage);
    }

    public static <T> ResponseServer<T> createByErrorMsg(int errorCode, String errorMessage) {
        return new ResponseServer<T>(errorCode, errorMessage);
    }

}
