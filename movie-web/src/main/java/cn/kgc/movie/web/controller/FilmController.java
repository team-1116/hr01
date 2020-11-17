package cn.kgc.movie.web.controller;

import cn.kgc.movie.common.pojo.DataPage;
import cn.kgc.movie.common.pojo.Film;
import cn.kgc.movie.common.pojo.Store;
import cn.kgc.movie.web.service.FlimService;
import cn.kgc.movie.web.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @program: movie
 * @ClassName FilmController
 * @description:
 * @author: 熊盛涛
 * @create: 2020-09-07 16:46
 * @Version 1.0
 **/
@Controller
public class FilmController {
    @Autowired
    private FlimService flimService;
    @Autowired
    private StoreService storeService;

    @Value("${manage.page.size}")
    private Integer pageSize;


    @RequestMapping("/tolist")
    public String tolist(Integer pageNum, Model model,
                         @RequestParam(value = "sid", required = false, defaultValue = "1") Integer sid,
                         @RequestParam(value = "pid", required = false, defaultValue = "0") Integer pid,
                         @RequestParam(value = "releaseDate", required = false, defaultValue = "1997-05-07") String releaseDate) {

        Date date = null;
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = format1.parse(releaseDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Integer page = pageNum == null ? 1 : pageNum;
        List<Store> storeList = storeService.getAllStore();
        DataPage<Film> pageF = flimService.getFilm(page, pageSize, sid, pid, date);
        model.addAttribute("storeList", storeList);
        model.addAttribute("pageF", pageF);
        model.addAttribute("sid", sid);
        model.addAttribute("pid", pid);
        model.addAttribute("date", date);
        return "index1";
    }
}
