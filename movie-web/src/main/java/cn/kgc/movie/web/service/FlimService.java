package cn.kgc.movie.web.service;

import cn.kgc.movie.common.pojo.DataPage;
import cn.kgc.movie.common.pojo.Film;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * @program: movie
 * @ClassName FlimService
 * @description:
 * @author: 熊盛涛
 * @create: 2020-09-07 16:33
 * @Version 1.0
 **/
@FeignClient("movie-service")
public interface FlimService {


    @GetMapping("/film/{pageNum}/{pageSize}/{sid}/{pid}/{releaseDate}")
    public DataPage<Film> getFilm(
            @PathVariable(value = "pageNum", required = true) Integer pageNum,
            @PathVariable(value = "pageSize", required = true) Integer pageSize,
            @PathVariable("sid") Integer sid,
            @PathVariable("pid") Integer pid,
            @PathVariable("releaseDate") Date releaseDate
    );

    @GetMapping("/film/{Fid}")
    public Film getFilmByFid(
            @PathVariable(value = "Fid", required = true) Integer Fid
    );

}
