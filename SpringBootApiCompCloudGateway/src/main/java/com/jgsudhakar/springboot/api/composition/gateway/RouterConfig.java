package com.jgsudhakar.springboot.api.composition.gateway;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*************************************
 * This Class is used to 
 * Author  : Sudhakar Tangellapalli
 * File    : com.jgsudhakar.springboot.api.compositionandaggregation.gateway.RouterConfig
 * Date    : 16-03-2025
 * Version : 1.0
 **************************************/
@Configuration
public class RouterConfig {

    @Bean
    public RestTemplateBuilder restTemplate(){
        return new RestTemplateBuilder();
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder, AggregationFilter aggregationFilter){
        return routeLocatorBuilder.routes()
                .route("composite-route", r -> r.path("/fetchusermenu/{id}")
                        .filters(f -> f.filter(aggregationFilter))
                        .uri("http://localhost:8080"))
                .build();
    }
}
