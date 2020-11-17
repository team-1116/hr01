package cn.kgc.movie.web.service;

import cn.kgc.movie.common.pojo.Store;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("movie-service")
public interface StoreService {
    @GetMapping("/store")
    public List<Store> getAllStore();
}
