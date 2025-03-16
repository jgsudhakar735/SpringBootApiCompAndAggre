package com.jgsudhakar.springboot.api.composition.gateway;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jgsudhakar.springboot.api.composition.gateway.dto.MenuDto;
import com.jgsudhakar.springboot.api.composition.gateway.dto.UserDto;
import com.jgsudhakar.springboot.api.composition.gateway.dto.UserMenuRespose;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/*************************************
 * This Class is used to 
 * Author  : Sudhakar Tangellapalli
 * File    : com.jgsudhakar.springboot.api.compositionandaggregation.gateway.AggregationFilter
 * Date    : 16-03-2025
 * Version : 1.0
 **************************************/
@Component
@Log4j2
public class AggregationFilter implements GatewayFilter {

    private static final String SERVICE_URL ="http://localhost:9090/sbtraining/api/";

    public RestTemplate restTemplate;

    public AggregationFilter(RestTemplateBuilder restTemplateBuilder){
        restTemplate = restTemplateBuilder.build();
    }

    /**
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        CompletableFuture<String> userResponse = CompletableFuture.supplyAsync(() -> {
            String id = exchange.getRequest().getPath().elements().get(3).value();
            return restTemplate.getForObject(SERVICE_URL + "user/"+id, String.class);
        });

        CompletableFuture menuResponse = CompletableFuture.supplyAsync(() -> {
            return restTemplate.getForObject(SERVICE_URL + "menu/admin", String.class);
        });
        return Mono.fromFuture(userResponse.thenCombine(menuResponse, (user, menu) -> {
            UserDto userDto = new Gson().fromJson(user, UserDto.class);
            Type personListType = new TypeToken<List<MenuDto>>() {
            }.getType();
            List menuDto = new Gson().fromJson((String) menu, personListType);
            UserMenuRespose userMenuRespose = new UserMenuRespose(userDto, menuDto);
            return userMenuRespose;
        })).flatMap(userMenuRespose -> {
            exchange.getResponse().setStatusCode(HttpStatus.OK);
            exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);
            return exchange.getResponse().writeWith(Mono.just(exchange.getResponse().bufferFactory().wrap(new Gson().toJson(userMenuRespose).getBytes())));
        });
    }
}
