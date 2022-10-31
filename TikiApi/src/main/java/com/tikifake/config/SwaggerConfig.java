package com.tikifake.config;

import java.util.Collections;
import java.util.Date;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	public static final String AUTHORIZATION_HEADER = "Authorization";
	public static final String DEFAULT_INCLUDE_PATTERN = "/.*";

	@Bean
	public Docket swaggerSpringfoxDocket() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).groupName(AUTHORIZATION_HEADER)
				.produces(Collections.singleton("application/json")).consumes(Collections.singleton("application/json"))
				.ignoredParameterTypes(Authentication.class)
				.directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
				.directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
				.directModelSubstitute(java.time.LocalDateTime.class, Date.class).useDefaultResponseMessages(false)
				.select().apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
				.paths(PathSelectors.any()).build();
		return docket;
	}

	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo("Tutorial REST API", "API For Tutorial Web", "API Ver1.0", "Terms of service",
				new Contact("Au Mau Duong", "aumauduong.com", "aumauduong@gmail.com"), "License of API",
				"API license URL", Collections.emptyList());
		return apiInfo;
	}
}
