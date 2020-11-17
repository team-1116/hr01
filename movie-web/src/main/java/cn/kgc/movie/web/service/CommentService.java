package cn.kgc.movie.web.service;

import cn.kgc.movie.common.pojo.Comment;
import cn.kgc.movie.common.pojo.DataPage;
import cn.kgc.movie.common.pojo.Store;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@FeignClient("movie-comment")
public interface CommentService {


    @GetMapping("/comment/{pageNum}/{pageSize}/{fid}")
    public DataPage<Comment> getCommentByFid(@PathVariable(value = "pageNum") Integer pageNum,
                                             @PathVariable(value = "pageSize") Integer pageSize,
                                             @PathVariable("fid") Integer fid);


    @PostMapping("/comment")
    public Map<String,String> savacomment(@RequestBody Comment comment);

}
