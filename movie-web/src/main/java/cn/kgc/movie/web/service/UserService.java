package cn.kgc.movie.web.service;

import cn.kgc.movie.common.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

@FeignClient("user-service")
public interface UserService {

    @GetMapping("/user/{userName}")
    public User getuser(@PathVariable String userName);


    @PostMapping("/user")
    public Map<String,String> savaUser(@RequestBody User user);

}
