package cn.kgc.movie.comment.controller;

import cn.kgc.movie.comment.service.CommentService;
import cn.kgc.movie.common.pojo.Comment;
import cn.kgc.movie.common.pojo.DataPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: movie
 * @ClassName CommentController
 * @description:
 * @author: 熊盛涛
 * @create: 2020-09-27 14:08
 * @Version 1.0
 **/
@RestController
public class CommentController {
        @Autowired
    private CommentService commentService;

        //查询电影评论
    @GetMapping("/comment/{pageNum}/{pageSize}/{fid}")
    public DataPage<Comment> getCommentByFid(@PathVariable(value = "pageNum") Integer pageNum,
                                             @PathVariable(value = "pageSize") Integer pageSize,
                                             @PathVariable("fid") Integer fid) {
        return commentService.getCommentByFid(pageNum, pageSize, fid);
    }


    //添加评论
        @PostMapping("/comment")
        public Map<String,String> savacomment(@RequestBody Comment comment){
            Map map=new HashMap();
            if (commentService.savaComment(comment)>0){
                map.put("msg","ok");
                return map;
            }
            map.put("msg","no");
            return map;
        }
}
