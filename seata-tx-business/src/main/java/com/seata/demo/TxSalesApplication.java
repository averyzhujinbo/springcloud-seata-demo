package com.seata.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName: SalesApplication
 * @Description:
 * @Author zjb
 * @Date: 2020-08-04 13:58
 * @Version V1.0
 */
@Slf4j
@EnableFeignClients(basePackages = "com.seata.demo.feign")
@SpringCloudApplication
@EnableConfigurationProperties
public class TxSalesApplication {
    public static void main(String[] args) {
        log.debug("SalesApplication startup main");
        SpringApplication application = new SpringApplication(TxSalesApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
