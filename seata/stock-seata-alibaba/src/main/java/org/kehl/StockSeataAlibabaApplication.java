package org.kehl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * springcloud-alibaba
 *
 * @author : kehl
 * @date : 2022-05-19 16:05
 **/
@SpringBootApplication
@EnableTransactionManagement //开启本地事务@Transactional
@EnableFeignClients
public class StockSeataAlibabaApplication {
    public static void main(String []args){
        SpringApplication.run(StockSeataAlibabaApplication.class,args);
    }
}
