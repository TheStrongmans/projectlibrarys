package com.catering.service;

import java.util.List;

import com.catering.dao.DiningTableDao;
import com.catering.entity.DiningTable;

public class DiningTableService {
	DiningTableDao dtDao = new DiningTableDao(); 
	// 返回所有餐桌信息
	public List<DiningTable> list(){
		return dtDao.queryMulti("select id,state from diningTable", DiningTable.class,null);
	}
	
	//根据id，查询对应的餐桌DiningTable 对象
	// 如果返回null 表示id编号对应的餐桌不存在
	public DiningTable getDiningTableById(int id) {
		return dtDao.queryStringle("select * from diningTable where id=?", DiningTable.class, id);
	}
	
	// 如果餐桌可以预定，调用方法，对其状态进行更新（包括预定的名字和电话）
	public boolean orderDiningTable(int id,String orderName,String orderTel) {
		int update = dtDao.update("update diningTable set state='已经预定',orderName=?,orderTel=? where id=?",orderName,orderTel,id );
		return update>0;
	}
	
	// 更新餐桌状态的方法
	public boolean updateDiningTableToFree(int id,String state) {
		return 0<dtDao.update("update diningTable set state=? where id=?",state, id);
	}
	
	//将指定的餐桌设置为空闲
	public boolean updateDiningTableState(int id,String state) {
		return 0<dtDao.update("update diningTable set state=?,orderName='',orderTel='' where id=?",state, id);
	}
	
}	
