package com.travelcc.utils;

import java.util.HashMap;
import java.util.List;

public class JsonDataPage extends JsonPage {
	private static final long serialVersionUID = 1L;

	public static JsonDataPage createJsonDataPage(List<?> rows, long total) {
		HashMap<String, Object> extParams = new HashMap<String, Object>();
		extParams.put("rows", rows);
		extParams.put("total", total);
		JsonDataPage jdp = new JsonDataPage();
		jdp.setCode(200);
		jdp.setSuccess(true);
		jdp.setExtParams(extParams);
		return jdp;
	}

}
