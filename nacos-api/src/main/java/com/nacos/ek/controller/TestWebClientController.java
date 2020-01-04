/*
 * @(#)com.cloud.food.controller 2020-01-04 11:41
 * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
 * @Blog：https://www.qekang.com
 * Copyright (c) 2019-2020 Shanghai
 * All rights reserved.

 * This software is the confidential and proprietary information of
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 */
package com.nacos.ek.controller;

import com.nacos.ek.result.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * *********************************************************
 *
 * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
 * @Date Created in $ $
 * @Title $.java
 * <p>Description: [ api调用方式 这里列举 服务消费方WebClient实现 ] </p>
 * <p>Blog: https://www.qekang.com</p>
 * <p>Inc:  </p>
 * <p>Copyright:    </p>
 * <p>Department: Product development </p>
 * *********************************************************
 */
@Slf4j
@RestController
@RequestMapping(value = {"/v1/webclient/api"}, method = {RequestMethod.GET, RequestMethod.POST}, consumes = {"*/*"}, produces = {"application/json"})
public class TestWebClientController {

    @Autowired
    private WebClient.Builder webClientBuilder;

    /**
     * Description: [ WebClient 调用入口 ]
     *
     * @param
     * @return reactor.core.publisher.Mono<java.lang.String>
     * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
     * @Date Created in 2020-01-04 13:44
     * <p>File:  </p>
     */
    @GetMapping("/test")
    public BaseResponse test() {
        Mono<String> result = webClientBuilder.build()
                .get()
                .uri("http://nacos-provider/v1/service/hello?name=WebClient调用实现")
                .retrieve()
                .bodyToMono(String.class);
        return BaseResponse.success(result);
    }

    /**
     * Description: [ 初始化 可以单独开个config ]
     *
     * @param
     * @return org.springframework.web.reactive.function.client.WebClient.Builder
     * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
     * @Date Created in 2020-01-04 13:43
     * <p>File:  </p>
     */
    @Bean
    @LoadBalanced
    public WebClient.Builder loadBalancedWebClientBuilder() {
        return WebClient.builder();
    }

}
