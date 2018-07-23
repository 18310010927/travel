package com.travelcc.bean;

public class VerifyReqParams extends ReqParams{

    /**
     *报价信息，参考搜索返回结果中的Routing Elements。 只含航班信息，不含价格信息
     */
    private Routing routing;

    public Routing getRouting() {
        return routing;
    }

    public void setRouting(Routing routing) {
        this.routing = routing;
    }

    @Override
    public String toString() {
        return "VerifyReqParams{" +
                "routing=" + routing +
                '}';
    }
}
