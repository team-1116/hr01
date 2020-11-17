package cn.kgc.movie.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program: movie
 * @ClassName CeControoler
 * @description:
 * @author: 熊盛涛
 * @create: 2020-09-29 08:56
 * @Version 1.0
 **/
@Controller
public class CeControoler {
        @GetMapping("/ceshi")
        public String ht(){
            return "seat";
        }


}
