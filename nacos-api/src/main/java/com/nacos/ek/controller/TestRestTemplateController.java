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
import org.springframework.web.client.RestTemplate;

/**
 * *********************************************************
 *
 * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
 * @Date Created in $ $
 * @Title $.java
 * <p>Description: [ api调用方式 这里列举 服务消费方RestTemplate实现 ] </p>
 * <p>Blog: https://www.qekang.com</p>
 * <p>Inc:  </p>
 * <p>Copyright:    </p>
 * <p>Department: Product development </p>
 * *********************************************************
 */
@Slf4j
@RestController
@RequestMapping(value = {"/v1/resttemplate/api"}, method = {RequestMethod.GET, RequestMethod.POST}, consumes = {"*/*"}, produces = {"application/json"})
public class TestRestTemplateController {

    @Autowired
    RestTemplate restTemplate;

    /**
     * Description: [ RestTemplate 调用入口 ]
     *
     * @param
     * @return java.lang.String
     * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
     * @Date Created in 2020-01-04 13:51
     * <p>File:  </p>
     */
    @GetMapping("/test")
    public BaseResponse test() {
        String result = restTemplate.getForObject("http://nacos-provider/v1/service/hello?name=RestTemplate调用实现", String.class);
        return BaseResponse.success(result);
    }

    /**
     * Description: [ 初始化 可以单独开个config ]
     *
     * @param
     * @return org.springframework.web.client.RestTemplate
     * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
     * @Date Created in 2020-01-04 13:48
     * <p>File:  </p>
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
