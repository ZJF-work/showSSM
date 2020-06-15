package com.hz.ssm.resp;

public class AddReqMsg {
    private int status;    //成功标识

    private String msg;    //错误提示

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
