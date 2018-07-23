package com.travelcc.bean;

import java.util.Arrays;

/**
 * 报价信息
 */
public class Routing {
	/**
	 * 可保存必要信息，之后生单按原值回转。最大 1000 个字符
	 */
	private String data;
	/**
	 * 成人单价（以元为单位）
	 */
	private Integer adultPrice;
	/**
	 * 成人税费（以元为单位）
	 */
	private Integer adultTax;
	/**
	 * 儿童单价（以元为单位）
	 */
	private Integer childPrice;
	/**
	 * 儿童税费（以元为单位）
	 */
	private Integer childTax;
	/**
	 * 报价类型：0 普通价 / 1 留学生价
	 */
	private Integer priceType;
	/**
	 * 报价类型：0 预定价 / 1 申请价
	 */
	private Integer applyType;
	/**
	 * 成人税费类型：0 未含税 / 1 已含税
	 */
	private Integer adultTaxType;
	/**
	 * 儿童税费类型：0 未含税 / 1 已含税
	 */
	private Integer childTaxType;
	/**
	 * 退改签信息
	 */
	private Rule rule;
	/**
	 * 去程航段按顺序
	 */
	private Segment[] fromSegments;
	/**
	 * 回程航段按顺序，参考下面的 Segment Element（单程搜索为空）
	 */
	private Segment[] retSegments;
	/**
	 * 参考信息，对查询请求的简化描述
	 */
	private String refData;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Integer getAdultPrice() {
		return adultPrice;
	}

	public void setAdultPrice(Integer adultPrice) {
		this.adultPrice = adultPrice;
	}

	public Integer getAdultTax() {
		return adultTax;
	}

	public void setAdultTax(Integer adultTax) {
		this.adultTax = adultTax;
	}

	public Integer getChildPrice() {
		return childPrice;
	}

	public void setChildPrice(Integer childPrice) {
		this.childPrice = childPrice;
	}

	public Integer getChildTax() {
		return childTax;
	}

	public void setChildTax(Integer childTax) {
		this.childTax = childTax;
	}

	public Integer getPriceType() {
		return priceType;
	}

	public void setPriceType(Integer priceType) {
		this.priceType = priceType;
	}

	public Integer getApplyType() {
		return applyType;
	}

	public void setApplyType(Integer applyType) {
		this.applyType = applyType;
	}

	public Integer getAdultTaxType() {
		return adultTaxType;
	}

	public void setAdultTaxType(Integer adultTaxType) {
		this.adultTaxType = adultTaxType;
	}

	public Integer getChildTaxType() {
		return childTaxType;
	}

	public void setChildTaxType(Integer childTaxType) {
		this.childTaxType = childTaxType;
	}

	public Rule getRule() {
		return rule;
	}

	public void setRule(Rule rule) {
		this.rule = rule;
	}

	public Segment[] getFromSegments() {
		return fromSegments;
	}

	public void setFromSegments(Segment[] fromSegments) {
		this.fromSegments = fromSegments;
	}

	public Segment[] getRetSegments() {
		return retSegments;
	}

	public void setRetSegments(Segment[] retSegments) {
		this.retSegments = retSegments;
	}

	public String getRefData() {
		return refData;
	}

	public void setRefData(String refData) {
		this.refData = refData;
	}

	@Override
	public String toString() {
		return "Routing{" + "data='" + data + '\'' + ", adultPrice=" + adultPrice + ", adultTax=" + adultTax
				+ ", childPrice=" + childPrice + ", childTax=" + childTax + ", priceType=" + priceType + ", applyType="
				+ applyType + ", adultTaxType=" + adultTaxType + ", childTaxType=" + childTaxType + ", rule=" + rule
				+ ", fromSegments=" + Arrays.toString(fromSegments) + ", retSegments=" + Arrays.toString(retSegments)
				+ ", refData='" + refData + '\'' + '}';
	}
}
