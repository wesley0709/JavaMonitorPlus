package com.wesley.server.database.dao;

import com.wesley.server.database.entity.ClassLoadEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ClassLoadMapper extends BaseMapper<ClassLoadEntity> {
	
	@Delete("delete from class_table")
	void deleteAll();
 
  
}
