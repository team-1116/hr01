package cn.kgc.movie.common.pojo;

/**
 * @program: Films
 * @ClassName projectionRoom
 * @description:
 * @author: 熊盛涛
 * @create: 2020-07-09 14:15
 * @Version 1.0
 **/
public class ProjectionRoom {
    /*
        放映厅id
    */
    private Integer projectionId;
    /*
        电影id
     */
    private Integer filmId;

    /*
        影院id

     */
    private Integer sId;

    public ProjectionRoom(Integer projectionId) {
        this.projectionId = projectionId;
    }

    public ProjectionRoom() {
        super();
    }

    public Integer getProjectionId() {
        return projectionId;
    }

    public void setProjectionId(Integer projectionId) {
        this.projectionId = projectionId;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }
}
