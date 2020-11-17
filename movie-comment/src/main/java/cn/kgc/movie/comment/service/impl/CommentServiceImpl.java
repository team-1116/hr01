package cn.kgc.movie.comment.service.impl;

import cn.kgc.movie.comment.mapper.CommentMapper;
import cn.kgc.movie.comment.service.CommentService;
import cn.kgc.movie.common.pojo.Comment;
import cn.kgc.movie.common.pojo.DataPage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: movie
 * @ClassName CommentServiceImpl
 * @description:
 * @author: 熊盛涛
 * @create: 2020-09-27 14:07
 * @Version 1.0
 **/

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public DataPage<Comment> getCommentByFid(Integer pageNum, Integer pageSize, Integer fid) {
        PageHelper.startPage(pageNum, pageSize);
        List<Comment> list = commentMapper.selectCommentByFid(fid);
        PageInfo<Comment> info = new PageInfo<>(list);
        DataPage<Comment> dataPage = new DataPage<>();
        dataPage.setRowCount(((Long) info.getTotal()).intValue());
        dataPage.setPageCount(info.getPages());
        dataPage.setPageNum(pageNum);
        dataPage.setPageSize(pageSize);
        dataPage.setDataList(info.getList());
        return dataPage;
    }

    @Override
    public Integer savaComment(Comment comment) {
        return commentMapper.addComment(comment);
    }
}
