package org.kehl.order.config;

import feign.Logger;
import org.kehl.order.interceptor.feign.CustomFeignInterceptor;
import org.springframework.context.annotation.Bean;


//@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

//    修改契约配置，支持Feign原生的注解
//    @Bean
//    public Contract feignContract(){
//        return new Contract.Default();
//    }
//

//超时时间配置
//    @Bean
//    public Request.Options options(){
//        return new Request.Options(5000,3000);
//    }


    /*
    自定义拦截器
     */
    @Bean
    public CustomFeignInterceptor feignAcceptGzipEncodingInterceptor(){
        return new CustomFeignInterceptor();
    }

}
