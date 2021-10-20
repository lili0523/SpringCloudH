package com.cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @date 2021年09月28日
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level getFeignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
