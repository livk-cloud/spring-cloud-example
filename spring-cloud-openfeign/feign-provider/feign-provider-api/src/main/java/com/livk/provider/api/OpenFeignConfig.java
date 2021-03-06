package com.livk.provider.api;

import feign.Feign;
import feign.Logger;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.commons.httpclient.OkHttpClientFactory;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.cloud.openfeign.support.FeignHttpClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * OpenFeignConfig
 * </p>
 *
 * @author livk
 * @date 2021/12/7
 */
@ComponentScan(basePackageClasses = OpenFeignConfig.class)
@AutoConfiguration(before = FeignAutoConfiguration.class)
@ConditionalOnClass(Feign.class)
public class OpenFeignConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        System.setProperty("logging.level.com.livk.provider.api.feign", "debug");
        return Logger.Level.FULL;
    }

    @Bean
    public okhttp3.OkHttpClient okHttpClient(OkHttpClientFactory okHttpClientFactory,
                                             FeignHttpClientProperties httpClientProperties) {
        return okHttpClientFactory.createBuilder(httpClientProperties.isDisableSslValidation())
                .connectTimeout(httpClientProperties.getConnectionTimeout(), TimeUnit.SECONDS)
                .followRedirects(httpClientProperties.isFollowRedirects()).build();
    }

}
