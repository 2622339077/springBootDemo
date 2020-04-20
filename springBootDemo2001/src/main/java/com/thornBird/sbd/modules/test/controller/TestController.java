package com.thornBird.sbd.modules.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	@RequestMapping("/test/appDesc")
	@ResponseBody
	//@ResponseBody该注解表示这个是一个接口，返回return内容，而不是路径。
	public String getDsc(){	
		return "Hello world,this is spring boot demo";
	}
}
