package cn.kgc.movie.service.controller;

import cn.kgc.movie.common.pojo.Store;
import cn.kgc.movie.service.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: Films
 * @ClassName StoreControoler
 * @description:
 * @author: 熊盛涛
 * @create: 2020-09-15 14:15
 * @Version 1.0
 **/
@RestController
public class StoreController {
    @Autowired
    private StoreService storeService;

    @GetMapping("/store")
    public List<Store> getAllStore() {
        return storeService.getAllStore();
    }

}
