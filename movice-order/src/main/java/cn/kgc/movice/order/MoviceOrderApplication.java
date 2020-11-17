package cn.kgc.movice.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@MapperScan("cn.kgc.movice.order.mapper")
@EnableEurekaClient
public class MoviceOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoviceOrderApplication.class, args);
    }

}
