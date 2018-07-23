package com.travelcc.bean;

/**
 * 搜索接口请求参数
 */
public class SearchReqParams extends ReqParams{

    /**
     * 出发地城市或机场IATA三字码代码
     */
    private String fromCity;
    /**
     *目的地城市或机场IATA三字码代码
     */
    private String toCity;
    /**
     * 去程时间，格式为YYYYMMDD
     */
    private String fromDate;
    /**
     * 回程日期，格式为YYYYMMDD（单程时无此参数）
     */
    private String retDate;

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getRetDate() {
        return retDate;
    }

    public void setRetDate(String retDate) {
        this.retDate = retDate;
    }

    @Override
    public String toString() {
        return "SearchReqParams{" +
                "fromCity='" + fromCity + '\'' +
                ", toCity='" + toCity + '\'' +
                ", fromDate='" + fromDate + '\'' +
                ", retDate='" + retDate + '\'' +
                '}';
    }
}
