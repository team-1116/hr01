package cn.kgc.movie.web.controller;

import cn.kgc.movie.common.pojo.Comment;
import cn.kgc.movie.common.pojo.DataPage;
import cn.kgc.movie.common.pojo.Film;
import cn.kgc.movie.common.pojo.Store;
import cn.kgc.movie.web.service.CommentService;
import cn.kgc.movie.web.service.FlimService;
import cn.kgc.movie.web.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: Films
 * @ClassName MovieInfoController
 * @description:
 * @author: 熊盛涛
 * @create: 2020-09-21 11:31
 * @Version 1.0
 **/
@Controller
public class MovieInfoController {

    @Value("${movieinfo.page.size}")
    private Integer pageSize;

    @Autowired
    private FlimService flimService;
    @Autowired
    private CommentService commentService;

    @RequestMapping("/tomovieInfo")
    public String tomoviceinfo(Integer pageNum, Model model,
                               @RequestParam(value = "fid") Integer fid) {
        Integer page = pageNum == null ? 1 : pageNum;
        Film film = flimService.getFilmByFid(fid);
        DataPage<Comment> pageC = commentService.getCommentByFid(page, pageSize, fid);
        model.addAttribute("film", film);
        model.addAttribute("pageC", pageC);
        return "movieInfo";
    }


    @ResponseBody
    @PostMapping("/savaComment")
    public String savaComment(Comment comment){
        Map<String,String> map=commentService.savacomment(comment);
            return map.get("msg");
    }
}
