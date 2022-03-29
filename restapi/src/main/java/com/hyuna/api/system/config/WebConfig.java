package com.hyuna.api.system.config;

import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Bean
	public MessageSource messageSource() {
	  ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
	  source.setBasename("classpath:/messages/messages");
	  source.setDefaultEncoding("UTF-8");
	  source.setUseCodeAsDefaultMessage(true);
	  source.setDefaultLocale(Locale.KOREA);
	  return source;
	}
	
	@Bean
	public MessageSource validationMessageSource() {
	  ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	  messageSource.setBasename("classpath:/messages/validation");
	  messageSource.setDefaultEncoding("UTF-8");
	  return messageSource;
	}
	
	@Bean
	public LocalValidatorFactoryBean getValidator() {
	  LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
	  bean.setValidationMessageSource(messageSource());
	  return bean;
	}
}
