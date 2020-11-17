package cn.kgc.movie.web.controller;

import cn.kgc.movie.common.pojo.Order;
import cn.kgc.movie.common.pojo.User;
import cn.kgc.movie.web.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @program: movie
 * @ClassName OrderController
 * @description:
 * @author: 熊盛涛
 * @create: 2020-09-27 15:33
 * @Version 1.0
 **/
@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

        @GetMapping("/goOrder")
        public String toOrder(HttpServletRequest request, Model model){
            String o="";
            HttpSession session = request.getSession();
           User user= (User) session.getAttribute("user");
           if (user==null){
               return "login";
           }
            List<Order>orders=orderService.getOrder(user.getId());
           //座位号进行自定义
           for (Order order : orders) {
                String info = order.getSeatNum();
                String[] s1 = info.split(",");
                o=s1[0]+"排"+s1[1]+"坐";
                order.setSeatNum(o);
            }
           model.addAttribute("orders",orders);
            return "order";
        }
}
