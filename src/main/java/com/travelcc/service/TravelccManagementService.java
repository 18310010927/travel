package com.travelcc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.travelcc.bean.ReqParams;
import com.travelcc.utils.EncryptionUtils;
import com.travelcc.utils.HttpRequestUtil;
import com.travelcc.utils.JsonUtil;

@Component
public class TravelccManagementService {

	private static final String URL = "http://api.travelcc.net/bjtufeng/";
	private static final String SEARCH = "http://47.100.198.138:8081/query/query";
	private static final String VERIFY = "http://47.100.198.138:8082/order/priceVerify";
	private static final String ORDER = "http://47.100.198.138:8082/order/order";

	private static final Logger logger = LoggerFactory.getLogger(TravelccManagementService.class);

	public <T> T send(String serviceName, ReqParams reqParams, final Class<T> clazz) {
		String requestJson = JsonUtil.toJson(reqParams);
		String resultJson = null;
		try {

			// 查询机票 search
			if ("search".equals(serviceName)) {
				logger.info(serviceName, requestJson);
				resultJson = HttpRequestUtil.post(SEARCH, requestJson);
			}

			// 机票校验 Verify
			if ("verify".equals(serviceName)) {
				logger.info(serviceName, requestJson);
				resultJson = HttpRequestUtil.post(VERIFY, requestJson);
				System.out.println(resultJson);
			}

			// 机票下单 order
			if ("order".equals(serviceName)) {
				logger.info("【接口名称】：{}，【请求的json字符串】：{}", serviceName, requestJson);
				requestJson = EncryptionUtils.encryption(requestJson);
				logger.info("【接口名称】：{}，【请求的json字符串(加密后)】：{}", serviceName, requestJson);
				resultJson = HttpRequestUtil.post(ORDER, requestJson);

				logger.info("【接口名称】：{}，【响应的json字符串（解密前）】：{}", serviceName, resultJson);
				resultJson = EncryptionUtils.deciphering(resultJson);
				logger.info("【接口名称】：{}，【响应的json字符串】：{}", serviceName, resultJson);
			}
			T t = JSON.parseObject(resultJson, clazz);
			return t;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}