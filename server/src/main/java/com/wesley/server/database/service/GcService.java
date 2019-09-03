package com.wesley.server.database.service;

import com.wesley.server.core.entity.KVEntity;
import com.wesley.server.database.dao.GcMapper;
import com.wesley.server.database.entity.GcEntity;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class GcService {
    @Autowired
    private GcMapper gcMapper;

    /**
     * 写入gc信息
     * @param name
     * @param date
     * @param kvEntities
     */
    public void write(String address, String name, String date, List<KVEntity> kvEntities) {
        GcEntity entity = new GcEntity();
        entity.setAddress(address);
        entity.setName(name);
        entity.setDate(date);
        entity.setS0C(kvEntities.get(0).getValue());
        entity.setS1C(kvEntities.get(1).getValue());
        entity.setS0U(kvEntities.get(2).getValue());
        entity.setS1U(kvEntities.get(3).getValue());
        entity.setEC(kvEntities.get(4).getValue());
        entity.setEU(kvEntities.get(5).getValue());
        entity.setOC(kvEntities.get(6).getValue());
        entity.setOU(kvEntities.get(7).getValue());
        entity.setMC(kvEntities.get(8).getValue());
        entity.setMU(kvEntities.get(9).getValue());
        entity.setCCSC(kvEntities.get(10).getValue());
        entity.setCCSU(kvEntities.get(11).getValue());
        entity.setYGC(kvEntities.get(12).getValue());
        entity.setYGCT(kvEntities.get(13).getValue());
        entity.setFGC(kvEntities.get(14).getValue());
        entity.setFGCT(kvEntities.get(15).getValue());
        entity.setGCT(kvEntities.get(16).getValue());
        gcMapper.insert(entity);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public List<GcEntity> findAllByAddressAndName(String address, String name) {
    	Map<String, Object> paramMap=new HashMap<>();
    	paramMap.put("name", name);
    	paramMap.put("address",address);
        return gcMapper.selectList(new QueryWrapper(paramMap));
    }
    
    @Async
    public void clearAll() {
    	gcMapper.deleteAll();
    }
}
