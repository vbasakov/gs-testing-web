package com.example.testingweb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@Value("${app.name}")
	String appName;

	@Value("${spring.application.name}")
	String appFullName;

	@RequestMapping("/")
	public @ResponseBody
	String greeting(
			@RequestParam(defaultValue = "Default", required = false) String param) {

		return String.format("%s%n%s%nhome%s", appName, appFullName, param);
	}

}
