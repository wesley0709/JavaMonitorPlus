package com.wesley.server.database.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 *  线程信息
 * @author admin
 */

@TableName("thread_table")
public class ThreadEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@TableId(type = IdType.AUTO)
    private Integer id;
    /**
	 * 当前应用名称  配置文件 spring.application.name=xxxx
	 */
	@TableField("name")
	private String name;
	/**
	 * 时间 格式 MM/dd HH:mm"
	 */
	@TableField("date")
    private String date;
	/**
	 * 总线程数
	 */
	@TableField("total")
	private int total;
	/**
	 * 运行中的线程
	 */
	@TableField("RUNNABLE")
    private int RUNNABLE;
	/**
	 * 这个状态就是有限的(时间限制)的WAITING, 一般出现在调用wait(long), join(long)等情况下, 另外一个线程sleep后
	 * 休眠的线程数
	 */
	@TableField("TIMED_WAITING")
	private int TIMED_WAITING;
	/**
	 * 这个状态下是指线程拥有了某个锁之后, 调用了他的wait方法, 等待的线程数
	 */
	@TableField("WAITING")
    private int WAITING;

	@TableField("address")
	@Setter
	@Getter
	private String address;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getRUNNABLE() {
		return RUNNABLE;
	}
	public void setRUNNABLE(int rUNNABLE) {
		RUNNABLE = rUNNABLE;
	}
	public int getTIMED_WAITING() {
		return TIMED_WAITING;
	}
	public void setTIMED_WAITING(int tIMED_WAITING) {
		TIMED_WAITING = tIMED_WAITING;
	}
	public int getWAITING() {
		return WAITING;
	}
	public void setWAITING(int wAITING) {
		WAITING = wAITING;
	}
    
    
    
}
