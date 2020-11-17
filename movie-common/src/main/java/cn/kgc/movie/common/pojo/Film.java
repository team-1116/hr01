package cn.kgc.movie.common.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @program: Films
 * @ClassName Film
 * @description:
 * @author: 熊盛涛
 * @create: 2020-07-09 14:02
 * @Version 1.0
 **/
public class Film {


    /*
        电影id
     */
    private Integer fid;
    /*
        电影名字
     */
    private String filmName;
    /*
        主要演员
     */
    private String actorName;
    /*
        电影发行公司
     */
    private String filmDistributionCorporation;
    /*
        上映时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    // @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date releaseDate;
    /*
        上映剧照
     */
    private String actionStill;
    /*
        剧情简介
     */
    private String synopsis;
    /*
        电影票价格
     */
    private Integer filmPrice;

    /*
        放映厅
     */
    private ProjectionRoom projectionRoom;

    /*
        电影类别
     */
    private List<FilmTypes> filmTypes;


    @Override
    public String toString() {
        return "Film{" +
                "fid=" + fid +
                ", filmName='" + filmName + '\'' +
                ", actorName='" + actorName + '\'' +
                ", filmDistributionCorporation='" + filmDistributionCorporation + '\'' +
                ", releaseDate=" + releaseDate +
                ", actionStill='" + actionStill + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", filmPrice=" + filmPrice +
                ", projectionRoom=" + projectionRoom +
                '}';
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getFilmDistributionCorporation() {
        return filmDistributionCorporation;
    }

    public void setFilmDistributionCorporation(String filmDistributionCorporation) {
        this.filmDistributionCorporation = filmDistributionCorporation;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getActionStill() {
        return actionStill;
    }

    public void setActionStill(String actionStill) {
        this.actionStill = actionStill;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Integer getFilmPrice() {
        return filmPrice;
    }

    public void setFilmPrice(Integer filmPrice) {
        this.filmPrice = filmPrice;
    }

    public ProjectionRoom getProjectionRoom() {
        return projectionRoom;
    }

    public void setProjectionRoom(ProjectionRoom projectionRoom) {
        this.projectionRoom = projectionRoom;
    }

    public List<FilmTypes> getFilmTypes() {
        return filmTypes;
    }

    public void setFilmTypes(List<FilmTypes> filmTypes) {
        this.filmTypes = filmTypes;
    }
}
