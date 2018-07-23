package com.travelcc.bean;

/**
 * 机票下单返回参数
 */
public class OrderRespResult extends RespResult {
	/**
	 * 会话标识：标记服务接口调用的唯一标识，相应的调用结果中会原值返回。数字或字母，长度小于 20 个字符
	 */
	private String sessionId;
	/**
	 * string 订单号，最大 100 个字符
	 */
	private String orderNo;
	/**
	 * PNR 编码，最大 30 个字符
	 */
	private String pnrCode;
	/**
	 * 可预订的座位数，最大为 9
	 */
	private Integer maxSeats;
	/**
	 * 报价信息
	 */
	private Routing routing;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getPnrCode() {
		return pnrCode;
	}

	public void setPnrCode(String pnrCode) {
		this.pnrCode = pnrCode;
	}

	public Integer getMaxSeats() {
		return maxSeats;
	}

	public void setMaxSeats(Integer maxSeats) {
		this.maxSeats = maxSeats;
	}

	public Routing getRouting() {
		return routing;
	}

	public void setRouting(Routing routing) {
		this.routing = routing;
	}

	@Override
	public String toString() {
		return "OrderRespResult{" + "sessionId='" + sessionId + '\'' + ", orderNo='" + orderNo + '\'' + ", pnrCode='"
				+ pnrCode + '\'' + ", maxSeats=" + maxSeats + ", routing=" + routing + '}';
	}
}
