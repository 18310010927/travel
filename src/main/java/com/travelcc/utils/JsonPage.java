package com.travelcc.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class JsonPage implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer code;
	private String msg;
	private boolean success;
	private Map<String, Object> extParams;

	public static JsonPage createSuccess() {
		return createSuccess(new HashMap<String, Object>());
	}

	public static JsonPage createSuccess(String msg) {
		return createSuccess(true, msg, new HashMap<String, Object>());
	}

	public static JsonPage createSuccess(Map<String, Object> extParams) {
		return createSuccess(true, "", extParams);
	}

	public static JsonPage createSuccess(boolean flag, String msg, Map<String, Object> extParams) {
		JsonPage jp = new JsonPage();
		jp.setCode(200);
		jp.setSuccess(flag);
		jp.setMsg(msg);
		jp.setExtParams(extParams == null ? new HashMap<String, Object>() : extParams);
		return jp;
	}

	public static JsonPage createErrorMsg(Integer code, String msg) {
		JsonPage jp = new JsonPage();
		jp.setCode(code);
		jp.setMsg(msg);
		return jp;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Map<String, Object> getExtParams() {
		return extParams;
	}

	public void setExtParams(Map<String, Object> extParams) {
		this.extParams = extParams;
	}

	@Override
	public String toString() {
		return "JsonPage [msg=" + msg + ", success=" + success + ", extParams=" + extParams + "]";
	}

}
