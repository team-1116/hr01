package cn.kgc.userservice.mapper;

import cn.kgc.movie.common.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
        User selectUserByUserName(@Param("userName") String userName);
        Integer insertUser(User user);
}
