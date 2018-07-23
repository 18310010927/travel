package com.travelcc.bean;

import java.util.Arrays;

/**
 * 搜索接口返回参数
 */
public class SearchRespResult extends RespResult{

    /**
     * 报价信息
     */
    private Routing [] routings;

    public Routing[] getRoutings() {
        return routings;
    }

    public void setRoutings(Routing[] routings) {
        this.routings = routings;
    }

    @Override
    public String toString() {
        return "SearchRespResult{" +
                "routings=" + Arrays.toString(routings) +
                '}';
    }
}
