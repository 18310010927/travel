package com.travelcc.bean;

public class ReqParams {
    /**
     * 接口身份标识用户名（渠道唯一标识）
     */
    private String cid;
    /**
     * 行程类型: 1.单程 2.往返
     */
    private Integer tripType;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Integer getTripType() {
        return tripType;
    }

    public void setTripType(Integer tripType) {
        this.tripType = tripType;
    }

    @Override
    public String toString() {
        return "ReqParams{" +
                "cid='" + cid + '\'' +
                ", tripType=" + tripType +
                '}';
    }
}
