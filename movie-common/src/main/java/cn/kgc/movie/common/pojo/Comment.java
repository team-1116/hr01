package cn.kgc.movie.common.pojo;

import java.util.Date;

/**
 * @program: Films
 * @ClassName Comment
 * @description:
 * @author: 熊盛涛
 * @create: 2020-07-16 11:48
 * @Version 1.0
 **/
public class Comment {
    /*
            评论id
     */
    private Integer id;
    /*
            评论内容
     */
    private String details;
    /*
        用户id
     */
    private Integer userId;
    /*
        电影id
     */
    private Integer flimFid;

    /*
    评论时间
     */
    private Date startTime;
    /*
        用户信息
     */
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFlimFid() {
        return flimFid;
    }

    public void setFlimFid(Integer flimFid) {
        this.flimFid = flimFid;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
