package cn.kgc.movie.comment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("cn.kgc.movie.comment.mapper")
@EnableEurekaClient
public class MovieCommentApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieCommentApplication.class, args);
    }

}
