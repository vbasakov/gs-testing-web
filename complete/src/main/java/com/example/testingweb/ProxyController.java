package com.example.testingweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProxyController {

	@RequestMapping("/proxy")
	public @ResponseBody String greeting(
			@RequestParam(defaultValue = "Default", required = false) String param) {

		return "proxy" + param;
	}

}
