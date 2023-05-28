package com.example.swimranking.config;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@Slf4j
public class SwaggerConfiguration {
    

    //http://localhost:8089/swagger-ui/index.html
	
	 @Bean public Docket api() { return new Docket(DocumentationType.OAS_30)
	 .select() .apis(RequestHandlerSelectors.any()) .paths(PathSelectors.any())
	 .build(); }
	 
	 @PostConstruct
	 public void init() {
		log.info("### Swagger URL : http://localhost:8089/swagger-ui/index.html");
	 }
}
