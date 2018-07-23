package com.travelcc.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by 111 on 2018/7/11.
 */
public class HttpResult {
    // 响应的状态码
    private int code;

    // 响应的响应体
    private JSONObject body;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public JSONObject getBody() {
		return body;
	}

	public void setBody(JSONObject body) {
		this.body = body;
	}

	public HttpResult(int code, JSONObject body) {
		super();
		this.code = code;
		this.body = body;
	}
    
    

  
}
