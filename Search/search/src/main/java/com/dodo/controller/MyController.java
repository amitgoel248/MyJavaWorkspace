package com.dodo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	@RequestMapping("/homePage")
	public String hello()
	{
		return "homePage";
	}
}
