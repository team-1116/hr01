package cn.kgc.movice.order.service;

import cn.kgc.movie.common.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderService {
    List<Order> getOrderByUserID(Integer userId);
}
