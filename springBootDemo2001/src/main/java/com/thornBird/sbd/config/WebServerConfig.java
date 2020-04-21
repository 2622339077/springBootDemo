package com.thornBird.sbd.config;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter({WebMvcAutoConfiguration.class})

//@AutoConfigureAfter覆盖到系统每一个配置文件之后
public class WebServerConfig {
	@Value(value = "${http.port}")
	private int httpPort;
	@Bean
	//定义连接器
	public Connector connector(){
		Connector connector = new Connector();
		connector.setScheme("http");
		connector.setPort(80);
		return connector;
	}
	
	@Bean
	public ServletWebServerFactory servletWebServerFactory(){
		TomcatServletWebServerFactory tomcatFactory = new TomcatServletWebServerFactory();
		tomcatFactory.addAdditionalTomcatConnectors(connector());
		return tomcatFactory;
		
	}
}
