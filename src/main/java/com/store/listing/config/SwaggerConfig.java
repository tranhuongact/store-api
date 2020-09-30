package com.store.listing.config;

import com.store.listing.ListingApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
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
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.store.listing"))
                .paths(PathSelectors.regex("/.*"))
                .build().apiInfo(apiEndPointsInfo());
    }

    private ApiInfo apiEndPointsInfo() {
        String version = "Version: " + ListingApplication.class.getPackage().getImplementationVersion();

        return new ApiInfoBuilder().title("Spring Boot RESTful API with Swagger")
                .description("API Store Listing")
                .contact(new Contact("listing", "ob-api.vndirect.com.vn", "thang.lam@vndirect.com.vn"))
                .license("actuator")
                .licenseUrl("https://bds-listing-api-uat.vndirect.com.vn/actuator")
                .version(version)
                .build();
    }
}

