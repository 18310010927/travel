package com.travelcc.bean;

import java.util.Arrays;

/**
 * 机票下单请求参数
 */
public class OrderReqParams extends ReqParams {
	/**
	 * Required 会话标识：标记服务接口调用的唯一标识，相应的调用结果中会原值返回。数字或字母，长度小于 20 个字符
	 */
	private String sessionId;
	/**
	 * Required 报价信息，参考搜索返回结果中的 Routing Elements。 只含航班信息，不含价格信息
	 */
	private Routing routing;
	/**
	 * Required 乘机人信息
	 */
	private Passengers[] passengers;
	/**
	 * 联系人信息
	 */
	private Contact contact;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Routing getRouting() {
		return routing;
	}

	public void setRouting(Routing routing) {
		this.routing = routing;
	}

	public Passengers[] getPassengers() {
		return passengers;
	}

	public void setPassengers(Passengers[] passengers) {
		this.passengers = passengers;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "OrderReqParams [sessionId=" + sessionId + ", routing=" + routing + ", passengers="
				+ Arrays.toString(passengers) + ", contact=" + contact + "]";
	}

}
