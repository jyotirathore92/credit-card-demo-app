package com.assessment.creditcard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configurations for displaying Swagger UI which shows the 
 * controllers and the apis present in the service(microservice)
 *
 * @author Jyoti
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(new ApiInfoBuilder().title("Credit Card APIs").description("Credit Card Microservice").build())
				.select().apis(RequestHandlerSelectors.basePackage("com.assessment.creditcard"))
				.paths(PathSelectors.any()).build();
	}
}
