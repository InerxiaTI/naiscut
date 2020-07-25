package com.inerxia.naiscut.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Profile("dev")
public class SwaggerConfiguration {

    @Bean
    public Docket usersApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(usersApiInfo())
                .select()
                .paths(PathSelectors.regex("/api.*"))
                .apis(RequestHandlerSelectors.any())
                .build();
    }

    private ApiInfo usersApiInfo() {
        return new ApiInfoBuilder()
                .title("NaisCut Api docs")
                .version("1.0")
                .license("Apache License Version 2.0")
                .description("Aquí están documentados todos los endpoints de la ApiNC 1.0")
                .build();
    }
}
