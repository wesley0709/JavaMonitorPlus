package com.wesley.server.database.service;

import com.wesley.server.core.entity.JstackEntity;
import com.wesley.server.database.dao.ThreadMapper;
import com.wesley.server.database.entity.ThreadEntity;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ThreadService {
    @Autowired
    private ThreadMapper threadMapper;

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public List<ThreadEntity> findAllByAddressAndName(String address, String name) {
    	Map<String, Object> paramMap=new HashMap<>();
    	paramMap.put("name", name);
    	paramMap.put("address",address);
        return threadMapper.selectList(new QueryWrapper(paramMap));
    }

    public void write(String address, String name, String date, JstackEntity jstatk) {
        ThreadEntity entity = new ThreadEntity();
        entity.setAddress(address);
        entity.setName(name);
        entity.setDate(date);
        entity.setTotal(jstatk.getTotal());
        entity.setRUNNABLE(jstatk.getRUNNABLE());
        entity.setTIMED_WAITING(jstatk.getTIMED_WAITING());
        entity.setWAITING(jstatk.getWAITING());
        threadMapper.insert(entity);
    }


    @Async
    public void clearAll() {
    	threadMapper.deleteAll();
    }
}
