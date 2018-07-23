package com.travelcc.bean;

public class RespResult {

    /**
     * 结果类型: 0 成功 / 其他 失败
     */
    private Integer status;
    /**
     * 提示信息，长度小于64个字符
     */
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RespResult{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                '}';
    }
}
