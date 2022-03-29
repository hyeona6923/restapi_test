package com.hyuna.api.system.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource({"classpath:/messages/messages.properties"})
@Component
public class MessageUtil
{
	@Autowired
	Environment env;
	
	public String get(String msg) {
		return this.env.getProperty(msg);
	}
}
