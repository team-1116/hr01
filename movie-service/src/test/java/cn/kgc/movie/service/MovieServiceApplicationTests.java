package cn.kgc.movie.service;

import cn.kgc.movie.service.mapper.FilmMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MovieServiceApplicationTests {
    @Autowired
    private FilmMapper filmMapper;

    @Test
    void contextLoads() {

    }

}
