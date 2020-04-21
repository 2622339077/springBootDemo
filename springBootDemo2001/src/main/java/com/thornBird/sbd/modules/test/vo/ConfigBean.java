package com.thornBird.sbd.modules.test.vo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:config/applicationTest.properties")
@ConfigurationProperties(prefix = "com.thorn.bird")
public class ConfigBean {
	// 设置applicationTest.properties配置文件中属性的前缀com.thorn.bird----驼峰命名不能用于前缀配置如:com.thornBird。可以用下划线或"."来配置。
	// 不设置前缀的写法
	/*
	 * @Value("${server.port}") private String port;
	 * 
	 * @Value("${com.thornBird.name}") private String name;
	 * 
	 * @Value("${com.thornBird.age}") private String age;
	 * 
	 * @Value("${com.thornBird.desc}") private String desc;
	 * 
	 * @Value("${com.thornBird.random}") private String random;
	 */
	// 设置前缀的写法
	private String name;
	private int age;
	private String desc;
	private String random;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getRandom() {
		return random;
	}

	public void setRandom(String random) {
		this.random = random;
	}

}
