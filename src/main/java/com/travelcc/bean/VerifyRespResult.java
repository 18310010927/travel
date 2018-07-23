package com.travelcc.bean;

/**
 * 机票校验相应结果
 */
public class VerifyRespResult extends RespResult {
	/**
	 * 会话标识：标记服务接口调用的唯一标识，相应的调用结果中会原值返回。数字或字母，长度小于 20 个字符
	 */
	private String sessionId;
	/**
	 * 可预订的座位数，最大为 9
	 */
	private Integer maxSeats;
	/**
	 * 报价信息
	 */
	private Routing routing;
	/**
	 * 退改签信息
	 */
	private Rule rule;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
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

	public Rule getRule() {
		return rule;
	}

	public void setRule(Rule rule) {
		this.rule = rule;
	}

	@Override
	public String toString() {
		return "VerifyRespResult{" + "sessionId='" + sessionId + '\'' + ", maxSeats=" + maxSeats + ", routing="
				+ routing + ", rule=" + rule + '}';
	}
}
