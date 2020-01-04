package com.nacos.ek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * *********************************************************
 *
 * @Author <a href="mailto:xyqierkang@163.com">qierkang</a>
 * Blog: https://www.qekang.com
 * @Title NacosApiApplication.java
 * @Date Created in 2019-11-25 19:10
 * <p>Description: [ TODO ] </p>
 * <p>Copyright:    </p>
 * <p>Company:      </p>
 * <p>Department:   </p>
 * *********************************************************
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class NacosApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosApiApplication.class, args);
    }

}