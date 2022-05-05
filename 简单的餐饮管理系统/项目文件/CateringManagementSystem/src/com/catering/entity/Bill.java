package com.catering.entity;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 与数据库表bill对应的实体类
 * @author stephen
 *
 */
public class Bill {
	private Integer id;
	private String billId;
	private Integer menuId;
	private Integer nums;
	private Double money;
	private Integer diningTableId;
	private LocalDateTime billdate;
	private String state;
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bill(Integer id, String billId, Integer menuId, Integer nums, Double money, Integer diningTableId,
			LocalDateTime billdate, String state) {
		super();
		this.id = id;
		this.billId = billId;
		this.menuId = menuId;
		this.nums = nums;
		this.money = money;
		this.diningTableId = diningTableId;
		this.billdate = billdate;
		this.state = state;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public Integer getNums() {
		return nums;
	}
	public void setNums(Integer nums) {
		this.nums = nums;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public Integer getDiningTableId() {
		return diningTableId;
	}
	public void setDiningTableId(Integer diningTableId) {
		this.diningTableId = diningTableId;
	}
	public LocalDateTime getBilldate() {
		return billdate;
	}
	public void setBilldate(LocalDateTime billdate) {
		this.billdate = billdate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return id+"\t"+nums+"\t"+money+"\t"+money+"\t"+diningTableId+"\t"+billdate+"\t"+state;
	}
	
}
