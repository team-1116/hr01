package cn.kgc.movie.service.service.impl;

import cn.kgc.movie.common.pojo.DataPage;
import cn.kgc.movie.common.pojo.Film;
import cn.kgc.movie.service.mapper.FilmMapper;
import cn.kgc.movie.service.service.FilmService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @program: movie
 * @ClassName FilmServiceImpl
 * @description:
 * @author: 熊盛涛
 * @create: 2020-09-07 16:15
 * @Version 1.0
 **/
@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    private FilmMapper filmMapper;


    @Override
    public DataPage<Film> getFlimByPidAndReleaseDate(Integer pageNum, Integer pageSize,
                                                     Integer sid, Integer pid, Date releaseDate) {

        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String datetime = format1.format(releaseDate);
        PageHelper.startPage(pageNum, pageSize);
        List<Film> list = filmMapper.selectFlimByPidAndReleaseDate(sid, pid, datetime);
        PageInfo<Film> info = new PageInfo<>(list);
        DataPage<Film> dataPage = new DataPage<>();
        dataPage.setRowCount(((Long) info.getTotal()).intValue());
        dataPage.setPageCount(info.getPages());
        dataPage.setPageNum(pageNum);
        dataPage.setPageSize(pageSize);
        dataPage.setDataList(info.getList());
        return dataPage;
    }

    @Override
    public Film getFlimByFid(Integer fid) {
        return filmMapper.selectFlimByFid(fid);
    }
}
