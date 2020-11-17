package cn.kgc.movice.order.controller;

import cn.kgc.movice.order.service.OrderService;
import cn.kgc.movie.common.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: movie
 * @ClassName OrderController
 * @description:
 * @author: 熊盛涛
 * @create: 2020-09-27 16:13
 * @Version 1.0
 **/
@RestController
public class OrderController {
        @Autowired
    private OrderService orderService;

        @GetMapping("/order/{userId}")
        public List<Order>getOrder(@PathVariable("userId") Integer userID){
            return  orderService.getOrderByUserID(userID);
        }
}
