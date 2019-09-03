package com.wesley.server.sys.dao;


import com.wesley.server.sys.entity.SysUserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUserEntity> {
	
}
