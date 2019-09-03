package com.wesley.server.database.dao;


import com.wesley.server.database.entity.GcEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface GcMapper extends BaseMapper<GcEntity> {
   
	@Delete("delete from gc_table")
	void deleteAll();
}
