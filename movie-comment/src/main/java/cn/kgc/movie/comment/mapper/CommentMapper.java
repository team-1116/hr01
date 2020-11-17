package cn.kgc.movie.comment.mapper;

import cn.kgc.movie.common.pojo.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {
    List<Comment> selectCommentByFid(@Param("fid") Integer fid);
    Integer addComment(Comment comment);
}
