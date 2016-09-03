package com.goodlaike.henghua.entity.model;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 恒华展会实体类
 * 
 * @author Jail Hu
 *
 */
public class HenghuaExhibition implements Serializable {

	// "{ "1": "{ \"结束时间\": \"2016-09-09 18:00:00\", \"开始时间\": \"2016-09-06
	// 08:00:00\", \"活动类型\": \"面料展会\", \"活动地址\": \"浙江省宁波市人民广场\", \"展会名称\":
	// \"宁波展会\" }" }"

	private static final long serialVersionUID = 1L;

	private int id;

	@JSONField(name = "开始时间")
	private String startTime;

	@JSONField(name = "结束时间")
	private String endTime;

	@JSONField(name = "活动类型")
	private String type;

	@JSONField(name = "活动地址")
	private String address;

	@JSONField(name = "展会名称")
	private String name;

	/**
	 * @return the "{ "1": "{ \"结束时间\": \"2016-09-09 18:00:00\", \"开始时间\": \"
	 *         2016-09-06 08:00:00\
	 *         ", \"活动类型\": \"面料展会\", \"活动地址\": \"浙江省宁波市人民广场\", \"展会名称\": \
	 *         "宁波展会\" }" }"
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the
	 */
	@JSONField(name = "startTime")
	public String getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime
	 *            the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the
	 */
	@JSONField(name = "endTime")
	public String getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime
	 *            the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the
	 */
	@JSONField(name = "type")
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the
	 */
	@JSONField(name = "address")
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the
	 */
	@JSONField(name = "name")
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HenghuaExhibition [id=" + id + ", startTime=" + startTime + ", endTime=" + endTime + ", type=" + type
				+ ", address=" + address + ", name=" + name + "]";
	}

}
