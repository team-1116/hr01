package cn.kgc.movie.common.pojo;

/**
 * @program: Films
 * @ClassName Store
 * @description:
 * @author: 熊盛涛
 * @create: 2020-07-11 11:54
 * @Version 1.0
 **/
public class Store {
    /*
        店子id
     */
    private Integer id;
    /*
        店子姓名
     */
    private String storeName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
