package com.catering.service;

import java.util.List;
import java.util.UUID;

import com.catering.dao.BillDao;
import com.catering.entity.Bill;

public class BillService {
	BillDao bDao = new BillDao();
	MenuService mService = new MenuService();
	DiningTableService dtService = new DiningTableService();
	
	//查看某个餐桌是否有未结账的账单
	public boolean hasPayBillByDiningTableId(int diningTableId) {
		return null!=bDao.queryStringle("select * from bill where diningTableId=? and state='未结账' limit 0,1", Bill.class,diningTableId);
	}
	
	//结账[]
	public boolean payBill(int diningTableId,String payMode) {
		//修改bill表
		int update = bDao.update("update bill set state=? where diningTableId=? and state='未结账'", payMode,diningTableId);
		if(update <= 0) {
			return false;
		}
		// 修改diningTable表
		if(dtService.updateDiningTableState(diningTableId, "空")) {
			return true;
		}else {
			return false;
		}
	}
	
	//返回所有的账单，提供给view使用
	public List<Bill> list(){
		return bDao.queryMulti("select * from bill", Bill.class);
	}
	
	// 点餐的方法
	public boolean orderMenu(int menuId,int nums,int diningTableId) {
		//生成一个账单号
		String billId = UUID.randomUUID().toString();
		//将账单生成到bill表
		int update = bDao.update("insert into bill values(null,?,?,?,?,?,now(),'未结账')", billId,menuId,nums,mService.getMenuById(menuId).getPrice()*nums,diningTableId);
		if(update <= 0)return false;
		//更新对应的餐桌状态
		return dtService.updateDiningTableState(diningTableId, "就餐中");
	}
}
