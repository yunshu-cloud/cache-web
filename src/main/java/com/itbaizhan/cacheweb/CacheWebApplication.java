package com.itbaizhan.cacheweb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class CacheWebApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(CacheWebApplication.class, args);
        log.error("*************服务启动成功*************");
    }

}
