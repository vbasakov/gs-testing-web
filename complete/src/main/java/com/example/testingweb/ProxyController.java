package com.example.testingweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProxyController {

	@RequestMapping("/proxy")
	public String proxy(
			@RequestParam(defaultValue = "Default", required = false) String param) {

		return "forward:/greetin?" + param;
	}

	@RequestMapping("/greetin")
	public @ResponseBody	String greeting(
			@RequestParam(defaultValue = "Default", required = false) String param) {

		return "greeting " + param;
	}

}
