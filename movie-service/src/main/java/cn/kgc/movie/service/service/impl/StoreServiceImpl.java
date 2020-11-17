package cn.kgc.movie.service.service.impl;

import cn.kgc.movie.common.pojo.Store;
import cn.kgc.movie.service.mapper.StoreMapper;
import cn.kgc.movie.service.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: Films
 * @ClassName StoreServiceImpl
 * @description:
 * @author: 熊盛涛
 * @create: 2020-09-15 14:14
 * @Version 1.0
 **/
@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    private StoreMapper storeMapper;

    @Override
    public List<Store> getAllStore() {
        return storeMapper.selectAllStore();
    }
}
