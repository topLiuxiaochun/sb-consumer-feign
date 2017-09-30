package com.liuxc.proSever.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * 为远程服务创建对应的接口，之后像调用本地服务一样调用远程服务。
 * @author dell
 *
 */
@FeignClient(value="compute-service")		//value指定服务提供者在注册中心的名字
public interface ConsumerService {

	/*
	public String getInfo() {
		return restTemplate.getForObject("http://" + SERVICE_NAME + "/add?a=10&b=20", String.class);
	}
	*/
	
	/**
	 * RequestMapping 注解，用来说明远程服务调用方式和地址
	 * @param a 当远程服务需要参数时，@RequestParam注解必须，说明参数名
	 * @param b
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET, value="/add")
	public String getInfo(@RequestParam("a") Integer a, @RequestParam("b") Integer b);
	
}
