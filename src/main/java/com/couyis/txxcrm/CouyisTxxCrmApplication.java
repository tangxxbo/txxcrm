package com.couyis.txxcrm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableEurekaClient
@EnableTransactionManagement(proxyTargetClass = true)
@EnableCaching
@ComponentScan("com.couyis.txxcrm.**")
@MapperScan("com.couyis.txxcrm.**.dao")
public class CouyisTxxCrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(CouyisTxxCrmApplication.class, args);
	}

}
