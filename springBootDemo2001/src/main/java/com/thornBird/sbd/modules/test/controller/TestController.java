package com.thornBird.sbd.modules.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thornBird.sbd.modules.test.vo.ConfigBean;

//@RestController = @Controller+@ResponseBody
@RestController
@RequestMapping("/api/test")
public class TestController {

	private final static Logger LOGGER = LoggerFactory.getLogger(TestController.class);
	@Value("${server.port}")
	private int port;
	@Value("${com.thornBird.name}")
	private String name;
	@Value("${com.thornBird.age}")
	private int age;
	@Value("${com.thornBird.desc}")
	private String desc;
	@Value("${com.thornBird.random}")
	private String random;

	@Autowired
	private ConfigBean configBean;

	// http://localhost:80/api/test/config
	@RequestMapping("/config")
	public String configTest() {
		StringBuffer sb = new StringBuffer();
		sb.append(port).append("----").append(name).append("----").append(age).append("----").append(desc)
				.append("----").append(random).append("----").append("<br>").append(configBean.getDesc()).append("----")
				.append(configBean.getName()).append("----").append(configBean.getRandom()).append("----")
				.append(configBean.getAge());
		return sb.toString();

	}

	// http://localhost:/api/test/appDesc
	@RequestMapping("/appDesc")
	// @ResponseBody该注解表示这个是一个接口，返回return内容，而不是路径。
	public String getDsc() {
		return "Hello world,this is spring boot demo";
	}

	// http://localhost:/api/test/logTest
	@RequestMapping("/logTest")
	public String logTest() {
		// level: TRACE<DEBUG<INFO<WARN<ERROR,大于等于的全部输出
		LOGGER.trace("This is TRACE log");
		LOGGER.debug("This is DEBUG log");
		LOGGER.info("This is INFO log");
		LOGGER.warn("This is WARN log");
		LOGGER.error("This is ERROR log");
		return "log test";

	}
}
