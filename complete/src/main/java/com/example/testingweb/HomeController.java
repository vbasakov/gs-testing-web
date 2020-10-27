package com.example.testingweb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@RequestMapping("/")
	public @ResponseBody
	String greeting(
			@RequestParam(defaultValue = "Default", required = false) String param,
			@RequestParam(defaultValue = "", required = false) String ticket) {

		return String.format("home %s %s", param, ticket);
	}

}
