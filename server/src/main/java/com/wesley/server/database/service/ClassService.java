package com.wesley.server.database.service;

import com.wesley.server.core.entity.KVEntity;
import com.wesley.server.database.dao.ClassLoadMapper;
import com.wesley.server.database.entity.ClassLoadEntity;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ClassService {
    @Autowired
    private ClassLoadMapper classLoadMapper;

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public List<ClassLoadEntity> findAllByAddressAndName(String address, String name) {
    	Map<String, Object> paramMap=new HashMap<>();
    	paramMap.put("name", name);
    	paramMap.put("address",address);
        return 	classLoadMapper.selectList(new QueryWrapper(paramMap));
    }

    /**
     *  写入类加载信息
     * @param name
     * @param date
     * @param jstatClass
     */
    public void write(String address, String name, String date, List<KVEntity> jstatClass) {
        ClassLoadEntity entity = new ClassLoadEntity();
        entity.setAddress(address);
        entity.setName(name);
        entity.setDate(date);
        entity.setLoaded(jstatClass.get(0).getValue());
        entity.setBytes1(jstatClass.get(1).getValue());
        entity.setUnloaded(jstatClass.get(2).getValue());
        entity.setBytes2(jstatClass.get(3).getValue());
        entity.setTime1(jstatClass.get(4).getValue());
        entity.setCompiled(jstatClass.get(5).getValue());
        entity.setFailed(jstatClass.get(6).getValue());
        entity.setInvalid(jstatClass.get(7).getValue());
        entity.setTime2(jstatClass.get(8).getValue());
        classLoadMapper.insert(entity);
    }


    @Async
    public void clearAll() {
    	classLoadMapper.deleteAll();
    }
}
