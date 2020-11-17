package cn.kgc.movie.web.controller;

import cn.kgc.movie.common.pojo.User;
import cn.kgc.movie.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: movie
 * @ClassName UserController
 * @description:
 * @author: 熊盛涛
 * @create: 2020-09-22 15:49
 * @Version 1.0
 **/
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    //查询用户
    @ResponseBody
    @PostMapping("/toUser")
    public String one(String userName,String password, HttpServletRequest request){
        HttpSession session = request.getSession();
        User user=userService.getuser(userName);
       //登录验证
        if (user==null){
            return "no";
        }else if (!user.getPassword().equals(password)){
            return "nop";
        }
        else {
            session.setAttribute("user",user);
            return "ok";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/passwordlength",method = RequestMethod.GET)
    public  String passwordlength(String password){
        if (password.length()<6){
            return "no";
        }
        return "ok";
    }


    //根据用户名查询
    @ResponseBody
    @RequestMapping(value = "/getuserName",method = RequestMethod.GET)
    public  String getloginName(String userName){
        User user=userService.getuser(userName);
        if (user!=null){
            return "no";
        }
        return "ok";
    }





    //添加用户
    @ResponseBody
    @RequestMapping(value = "/savaUser",method = RequestMethod.POST)
    public String savaQuestions(User user){
        Map<String,String> map=userService.savaUser(user);
        return map.get("msg");
    }


    //判断手机格式
    @ResponseBody
    @RequestMapping(value = "/phone",method = RequestMethod.GET)
    public String phone(String phone){
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(phone);
        if (phone.length()!=11){
            return "length";
        }else if (!m.matches()){
            return "no";
        }

        return "ok";
    }

}
