package cn.kgc.movie.service.controller;

import cn.kgc.movie.common.pojo.DataPage;
import cn.kgc.movie.common.pojo.Film;
import cn.kgc.movie.service.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @program: movie
 * @ClassName FilmControoler
 * @description:
 * @author: 熊盛涛
 * @create: 2020-09-07 16:17
 * @Version 1.0
 **/
@RestController
public class FilmController {
    @Autowired
    private FilmService filmService;

    @GetMapping("/film/{pageNum}/{pageSize}/{sid}/{pid}/{releaseDate}")
    public DataPage<Film> getFilm(@PathVariable(value = "pageNum") Integer pageNum,
                                  @PathVariable(value = "pageSize") Integer pageSize,
                                  @PathVariable("sid") Integer sid,
                                  @PathVariable("pid") Integer pid,
                                  @PathVariable("releaseDate") Date releaseDate
    ) {

        //Date releaseDate = null;
//        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
//        String  str = "2020-07-01";
//        try {
//            releaseDate = format1.parse(str);
//        } catch (ParseException e) {
//
//        }
        return filmService.getFlimByPidAndReleaseDate(pageNum, pageSize, sid, pid, releaseDate);
    }

    @GetMapping("/film/{fid}")
    public Film getfilmByFid(@PathVariable("fid") Integer fid) {
        return filmService.getFlimByFid(fid);
    }

}
