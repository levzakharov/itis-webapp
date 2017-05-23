package com.itis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author aleksandrpliskin on 13.05.17.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    @Autowired
    public Docket api(final ApiInfo apiInfo) {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("(/api/.*)|(/oauth/(token|authorize))"))
                .build()
                .apiInfo(apiInfo);
    }

    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("ITIS-Portal API")
                .version("1.0.0")
                .license("(C) 11-401 ITIS 2017")
                .description("The API for ITIS-Portal")
                .build();
    }
}