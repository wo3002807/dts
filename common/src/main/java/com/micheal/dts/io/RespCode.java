package com.micheal.dts.io;


import com.alibaba.fastjson.JSONObject;

/**
 * 基础返回码
 */
public class RespCode {
    private String retCode;
    private String retMsg;

    public RespCode() {
        retCode = "000000";
        retMsg = "处理成功";
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}
