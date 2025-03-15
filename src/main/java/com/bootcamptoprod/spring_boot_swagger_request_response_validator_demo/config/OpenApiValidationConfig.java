package com.bootcamptoprod.spring_boot_swagger_request_response_validator_demo.config;

import com.atlassian.oai.validator.springmvc.OpenApiValidationFilter;
import com.atlassian.oai.validator.springmvc.OpenApiValidationInterceptor;
import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Configuration
public class OpenApiValidationConfig {

    // Register a filter that validates both requests and responses.
    @Bean
    public Filter validationFilter() {
        return new OpenApiValidationFilter(
                true, // enable request validation
                true  // enable response validation
        );
    }

    // Register an interceptor using the OpenAPI specification file.
    @Bean
    public WebMvcConfigurer addOpenApiValidationInterceptor(
            @Value("classpath:ecommerce-product-api.yaml") final Resource apiSpecification) throws IOException {
        final EncodedResource encodedResource = new EncodedResource(apiSpecification, StandardCharsets.UTF_8);
        final OpenApiValidationInterceptor openApiValidationInterceptor = new OpenApiValidationInterceptor(encodedResource);

        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(openApiValidationInterceptor);
            }
        };
    }
}
