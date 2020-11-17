package cn.kgc.userservice.service.impl;

import cn.kgc.movie.common.pojo.User;
import cn.kgc.userservice.mapper.UserMapper;
import cn.kgc.userservice.service.UserService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: movie
 * @ClassName UserServiceImpl
 * @description:
 * @author: 熊盛涛
 * @create: 2020-09-22 15:39
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {
        @Autowired
        private UserMapper userMapper;

    @Override
    public User getUserByUserNameAndPassword(String userName) {
        return userMapper.selectUserByUserName(userName);
    }

    @Override
    public Integer savaUser(User user) {
        return userMapper.insertUser(user);
    }
}
