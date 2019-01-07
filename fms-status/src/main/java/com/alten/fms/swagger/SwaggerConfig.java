package com.alten.fms.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

 /*   private ApiInfo apiInfo() {
        return new ApiInfo(
                "Vehicle API",
                "This is the vehicle API which is used to execute basic operation on vehicles.",
                "API 1.0",
                "",
                new Contact("Bassam AbouZaid", "", "b.s.abouzaid@gmail.com"),
                "", "", Collections.emptyList());
    }*/
}
