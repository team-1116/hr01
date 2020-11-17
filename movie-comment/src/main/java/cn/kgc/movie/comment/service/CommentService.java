package cn.kgc.movie.comment.service;

import cn.kgc.movie.common.pojo.Comment;
import cn.kgc.movie.common.pojo.DataPage;

public interface CommentService {
    DataPage<Comment> getCommentByFid(Integer pageNum, Integer pageSize, Integer fid);
    Integer savaComment(Comment comment);
}
