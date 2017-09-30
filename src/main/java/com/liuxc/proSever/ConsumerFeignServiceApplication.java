package com.liuxc.proSever;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient		// 注册服务到注册中心
@SpringBootApplication
@EnableFeignClients			// 开启feign寻找服务模式
public class ConsumerFeignServiceApplication {

	/**
	 * RestTemplate 为远程调用模板工具类，方便使用注册中心的服务
	 * @return
	 */
	@Bean
	@LoadBalanced // 当注册中心同一个服务有多个实例时，可以负载均衡，由ribbon带来该给功能
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumerFeignServiceApplication.class, args);

	}

}
