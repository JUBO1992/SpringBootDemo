package com.jubo.springboot01.common.utils;

/**
 * @author JUBO
 * @version 1.0.0
 * @date 2021/03/14
 */
public class RespStat {
    /**
     * JSON报文状态码
     * 用于前端判断 200=成功
     * 400/500出错
     * code 状态码
     * msg 信息
     * data 数据
     */
    private int code;
    private String msg;
    private String data;

    public RespStat() {
    }

    public RespStat(int code, String msg, String data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public static RespStat build(int code, String msg) {
        return new RespStat(code, msg, "");
    }
}
