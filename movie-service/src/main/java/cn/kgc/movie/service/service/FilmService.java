package cn.kgc.movie.service.service;

import cn.kgc.movie.common.pojo.DataPage;
import cn.kgc.movie.common.pojo.Film;

import java.util.Date;
import java.util.List;

public interface FilmService {
    DataPage<Film> getFlimByPidAndReleaseDate(Integer pageNum, Integer pageSize, Integer sid, Integer pid, Date releaseDate);

    Film getFlimByFid(Integer fid);

}
