package cn.kgc.movice.order.mapper;

import cn.kgc.movie.common.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    List<Order>selectOrderByUserID(@Param("userId") Integer userId);
}
