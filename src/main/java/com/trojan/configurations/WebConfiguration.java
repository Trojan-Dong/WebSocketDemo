package com.trojan.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
//	@Autowired
//	private LoginInterceptor loginInterceptor;

	/*
	 * 配置静态资源的，比如html，js，css，等
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	}

	/*
	 * 注册拦截器，我拦截器需要通过\添加注册后生效
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/login", "/register","/index");;
	}
}
