package cn.kgc.movie.web.service;


import cn.kgc.movie.common.pojo.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("movie-order")
public interface OrderService {

    @GetMapping("/order/{userId}")
    public List<Order> getOrder(@PathVariable("userId") Integer userID);
}
