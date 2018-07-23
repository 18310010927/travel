package com.travelcc.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.travelcc.bean.OrderReqParams;
import com.travelcc.bean.OrderRespResult;
import com.travelcc.bean.SearchReqParams;
import com.travelcc.bean.SearchRespResult;
import com.travelcc.bean.VerifyReqParams;
import com.travelcc.bean.VerifyRespResult;

@Service
public class TravelccService {
	@Resource
	private TravelccManagementService travelccManagementService;

	/**
	 * 查询机票接口
	 * 
	 * @param searchReqParams
	 *            查询请求参数
	 * @return
	 */
	public SearchRespResult search(SearchReqParams searchReqParams) {
		return travelccManagementService.send("search", searchReqParams, SearchRespResult.class);
	}

	/**
	 * 机票校验
	 * 
	 * @param verifyReqParams
	 *            校验请求参数
	 * @return
	 */
	public VerifyRespResult verify(VerifyReqParams verifyReqParams) {
		return travelccManagementService.send("verify", verifyReqParams, VerifyRespResult.class);
	}

	/**
	 * 机票下单
	 * 
	 * @param orderReqParams
	 *            下单请求参数
	 * @return
	 */
	public OrderRespResult order(OrderReqParams orderReqParams) {
		return travelccManagementService.send("order", orderReqParams, OrderRespResult.class);
	}

}
