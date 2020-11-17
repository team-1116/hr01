package cn.kgc.movie.common.pojo;

/**
 * @program: Films
 * @ClassName User
 * @description:
 * @author: 熊盛涛
 * @create: 2020-07-16 11:45
 * @Version 1.0
 **/
public class User {
    /*
            用户表id
     */
    private Integer id;

    /*
        用户账号
     */
    private String userName;
    /*
        手机号
     */
    private String phone;
    /*
        密码
     */
    private String password;
    /*
           用户姓名
     */
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
