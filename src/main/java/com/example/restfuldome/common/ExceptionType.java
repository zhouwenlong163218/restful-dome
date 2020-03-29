package com.example.restfuldome.common;

public enum  ExceptionType {
    SUCCESS(200,"成功"),
    USER_INPUT_ERROR(400,"用户输入异常"),
    SERVER_ERROR(500,"系统服务异常"),
    NOT_FOUND_ERROR(404,"没找打"),
    OTHER_ERROR(999,"其他未知异常"),
    ;
    private int code;

    public int getCode() {
        return code;

        //
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private String msg;
    ExceptionType(int code, String msg) {
        this.code =code;
        this.msg = msg;
    }



}
