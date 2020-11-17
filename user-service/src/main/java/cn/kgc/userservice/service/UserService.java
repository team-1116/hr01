package cn.kgc.userservice.service;

import cn.kgc.movie.common.pojo.User;

public interface UserService {
    User getUserByUserNameAndPassword(String userName);
    Integer savaUser(User user);
}
