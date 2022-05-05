package com.catering.entity;
/**
 * 与数据库表diningTable对应的实体类
 * @author stephen
 *
 */
public class DiningTable {
	private Integer id;
	private String state;
	private String orderName;
	private String orderTel;
	public DiningTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DiningTable(Integer id, String state, String orderName, String orderTel) {
		super();
		this.id = id;
		this.state = state;
		this.orderName = orderName;
		this.orderTel = orderTel;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getOrderTel() {
		return orderTel;
	}
	public void setOrderTel(String orderTel) {
		this.orderTel = orderTel;
	}
	@Override
	public String toString() {
		return id + "\t\t" + state;
	}
	
}
