package com.example.springbootecommerce.config;

import com.example.springbootecommerce.entity.Product;
import com.example.springbootecommerce.entity.ProductCategory;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;


@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {


    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors){

        HttpMethod[] theUnsupportedMethod = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};

        //this will disable http method for product: post, put and delete
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedMethod)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedMethod)));


        //this will disable http method for product: post, put and delete
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedMethod)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedMethod)));

    }
}
