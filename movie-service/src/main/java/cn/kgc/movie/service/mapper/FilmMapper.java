package cn.kgc.movie.service.mapper;

import cn.kgc.movie.common.pojo.Film;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface FilmMapper {
    List<Film> selectFlimByPidAndReleaseDate(@Param("sid") Integer sid, @Param("pid") Integer pid, @Param("releaseDate") String releaseDate);

    Film selectFlimByFid(@Param("fid") Integer fid);

}
