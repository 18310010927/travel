package com.travelcc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.travelcc.bean.OrderReqParams;
import com.travelcc.bean.OrderRespResult;
import com.travelcc.bean.Routing;
import com.travelcc.bean.SearchReqParams;
import com.travelcc.bean.SearchRespResult;
import com.travelcc.bean.VerifyReqParams;
import com.travelcc.bean.VerifyRespResult;
import com.travelcc.service.TravelccService;
import com.travelcc.utils.JsonPage;

@RequestMapping("/travelcc")
@Controller
public class TravelccController {
	private static final Logger logger = LoggerFactory.getLogger(TravelccController.class);
	@Resource
	private TravelccService travelccService;
	private static Map map = new HashMap<String, Object>();
	private static Map m2 = new HashMap<String, Object>();

	/**
	 * 查询机票
	 * 
	 * @param searchReqParams
	 * @return
	 */
	@PostMapping("/search")
	@ResponseBody
	public Map search(SearchReqParams searchReqParams) {
		Map extParams = new HashMap<String, Object>();
		SearchRespResult searchRespResult = travelccService.search(searchReqParams);
		Routing[] routings = searchRespResult.getRoutings();
		extParams.put("rows", routings);
		extParams.put("total", routings.length);
		map.put("routings", routings);
		logger.info(searchRespResult.toString());
		if (searchRespResult.getStatus() == 0) {
			// return JsonPage.createSuccess(extParams);
			return extParams;
		} else {
			// return JsonPage.createErrorMsg(1,"请求错误");
			return null;
		}
	}

	/**
	 * 验舱验价 Verify
	 * 
	 * @param
	 * @return
	 */
	@GetMapping("/verification")
	public ModelAndView verification(String cid, Integer tripType) {
		VerifyReqParams verifyReqParams = new VerifyReqParams();
		verifyReqParams.setCid(cid);
		verifyReqParams.setTripType(tripType);
		Routing[] routings = (Routing[]) map.get("routings");
		verifyReqParams.setRouting(routings[0]);
		ModelAndView modelAndView = new ModelAndView("order");
		Map extParams = new HashMap<String, Object>();
		VerifyRespResult verifyRespResult = travelccService.verify(verifyReqParams);
		extParams.put("verifyRespResult", verifyRespResult);
		m2.put("verifyRespResult", verifyRespResult);
		modelAndView.addAllObjects(extParams);
		return modelAndView;

	}

	/**
	 * 机票下单 order
	 * 
	 * @param
	 * @return
	 */
	@PostMapping("/order")
	@ResponseBody
	public JsonPage order(@RequestBody OrderReqParams orderReqParams) {
		Map extParams = new HashMap<String, Object>();
		VerifyRespResult verifyRespResult = (VerifyRespResult) m2.get("verifyRespResult");
		String sessionId = verifyRespResult.getSessionId();
		Routing routing = verifyRespResult.getRouting();

		orderReqParams.setSessionId(sessionId);
		orderReqParams.setRouting(routing);
		OrderRespResult orderRespResult = travelccService.order(orderReqParams);
		extParams.put("orderRespResult", orderRespResult);

		if (orderRespResult.getStatus() == 0) {
			return JsonPage.createSuccess(extParams);
		} else {
			return JsonPage.createErrorMsg(1, "请求错误");
		}

	}

	/**
	 * 机票下单 order
	 * 
	 * @param
	 * @return
	 */
	@PostMapping("/order2")
	@ResponseBody
	public JsonPage order2(@RequestBody OrderReqParams orderReqParams) {
		Map extParams = new HashMap<String, Object>();
		OrderRespResult orderRespResult = travelccService.order(orderReqParams);
		extParams.put("orderRespResult", orderRespResult);
		if (orderRespResult.getStatus() == 0) {
			return JsonPage.createSuccess(extParams);
		} else {
			return JsonPage.createErrorMsg(1, "请求错误");
		}
	}
}
