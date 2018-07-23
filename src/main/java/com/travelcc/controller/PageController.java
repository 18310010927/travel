package com.travelcc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	@RequestMapping("/searchPage")
	public String searchPage() {
		return "search";
	}

	@RequestMapping("/orderPage")
	public String orderPage() {
		return "orderinfo";
	}
}
