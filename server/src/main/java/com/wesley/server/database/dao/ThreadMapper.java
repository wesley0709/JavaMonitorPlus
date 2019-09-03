package com.wesley.server.database.dao;

import com.wesley.server.database.entity.ThreadEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ThreadMapper extends BaseMapper<ThreadEntity> {
   
    
	@Delete("delete from thread_table")
	void deleteAll();
}
