package cn.kgc.movie.common.pojo;

/**
 * @program: Films
 * @ClassName Filmtypes
 * @description:
 * @author: 熊盛涛
 * @create: 2020-07-09 14:12
 * @Version 1.0
 **/
public class FilmTypes {
    /*
        电影类别id
     */
    private Integer id;
    /*
        类别名称
     */
    private String typeName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
