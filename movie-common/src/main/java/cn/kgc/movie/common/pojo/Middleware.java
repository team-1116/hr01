package cn.kgc.movie.common.pojo;

/**
 * @program: Films
 * @ClassName Middleware
 * @description:
 * @author: 熊盛涛
 * @create: 2020-07-09 14:14
 * @Version 1.0
 **/
public class Middleware {
    /*
        电影id
     */
    private Integer filmId;
    /*
        电影类别id
     */
    private Integer typesId;

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Integer getTypesId() {
        return typesId;
    }

    public void setTypesId(Integer typesId) {
        this.typesId = typesId;
    }
}
