package com.seata.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName: TxStorageApplication
 * @Description:
 * @Author zjb
 * @Date: 2020-07-30 14:01
 * @Version V1.0
 */
@Slf4j
@EnableFeignClients(basePackages = "com.seata.demo.feign")
@SpringCloudApplication
@EnableConfigurationProperties
public class TxStorageApplication {
    public static void main(String[] args) {
        log.debug("TxStorageApplication startup main");
        SpringApplication application = new SpringApplication(TxStorageApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
