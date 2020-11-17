package cn.kgc.movice.order.service.impl;

import cn.kgc.movice.order.mapper.OrderMapper;
import cn.kgc.movice.order.service.OrderService;
import cn.kgc.movie.common.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: movie
 * @ClassName OrderServiceImpl
 * @description:
 * @author: 熊盛涛
 * @create: 2020-09-27 16:12
 * @Version 1.0
 **/
@Service
public class OrderServiceImpl implements OrderService {
        @Autowired
        private OrderMapper orderMapper;
    @Override
    public List<Order> getOrderByUserID(Integer userId) {
        return orderMapper.selectOrderByUserID(userId);
    }
}
