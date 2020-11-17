package cn.kgc.userservice.controller;

import cn.kgc.movie.common.pojo.User;
import cn.kgc.userservice.service.UserService;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: movie
 * @ClassName UserController
 * @description:
 * @author: 熊盛涛
 * @create: 2020-09-22 15:41
 * @Version 1.0
 **/
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/user/{userName}")
    public User getuser(@PathVariable String userName){
            return userService.getUserByUserNameAndPassword(userName);
    }

    @PostMapping("/user")
    public Map<String,String>savaUser(@RequestBody User user){
        Map<String,String>map=new HashMap<>();
        if (userService.savaUser(user)>0){
            map.put("msg","ok");
            return map;
        }
        map.put("msg","no");
        return map;
    }
}
