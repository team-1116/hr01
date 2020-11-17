package cn.kgc.movie.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: movie
 * @ClassName Login
 * @description:
 * @author: 熊盛涛
 * @create: 2020-09-22 15:19
 * @Version 1.0
 **/
@Controller
public class Login {
        @RequestMapping("/goLogin")
    public String tologin(){
            return "login";
        }

        @RequestMapping("/goRegister")
        public String touserregister(){
            return "user-register";
        }
}
