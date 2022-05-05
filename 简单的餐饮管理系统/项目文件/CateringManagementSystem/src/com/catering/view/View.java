package com.catering.view;

import java.util.Iterator;
import java.util.List;

import com.catering.entity.Bill;
import com.catering.entity.DiningTable;
import com.catering.entity.Employee;
import com.catering.entity.Menu;
import com.catering.service.BillService;
import com.catering.service.DiningTableService;
import com.catering.service.EmployessService;
import com.catering.service.MenuService;
import com.catering.utils.In;

public class View {
	// 控制是否退出菜单
	private boolean loop = true;
	private String key;
	// EmployessService
	EmployessService empService = new EmployessService(); 
	DiningTableService dtService = new DiningTableService();
	MenuService mService = new MenuService();
	BillService bService = new BillService();
	
	public static void main(String[] args) {
		new View().mainMenu();
	}
	
	// 显示主菜单
	public void mainMenu() {
		while(loop) {
			System.out.println("============== 餐饮管理系统 ============");
			System.out.println("\t\t 1 登录");
			System.out.println("\t\t 2 退出");
			System.out.println("请选择：");
			key = In.next();
			switch(key) {
				case "1":
//					System.out.println("登录");
					System.out.println("输入员工号");
					String id = In.next();
					System.out.println("输入密码");
					String pwd = In.next();
					// 
					Employee employee = empService.getEmployeeByIdAndPwd(id, pwd);
					if(employee!=null) {
						System.out.println("============== 登录成功 ============");
						//显示二级菜单
						while(loop) {
							System.out.println("============== 餐饮管理系统 用户("+employee.getName()+") ============");
							System.out.println("1 显示餐桌状态");
							System.out.println("2 预定餐桌");
							System.out.println("3 显示所有菜品");
							System.out.println("4 点餐");
							System.out.println("5 查看账单");
							System.out.println("6 结账");
							System.out.println("9 退出");
							System.out.println("请输入：");
							key = In.next();
							switch (key) {
							case "1":
//								System.out.println("显示餐桌状态");
								listDiningTable();
								break;
							case "2":
//								System.out.println("预定餐桌");
								orderDiningTable();
								break;
							case "3":
//								System.out.println("显示所有菜品");
								listMenu();
								break;
							case "4":
//								System.out.println("点餐服务");
								orderMenu();
								break;
							case "5":
//								System.out.println("查看账单");
								listBill();
								break;
							case "6":
//								System.out.println("结账");
								payBill();
								break;
							case "9":
								System.out.println("退出登录");
								loop = false;
								break;
							default:
								System.out.println("输入有误，请重新输入");
								break;
							}
							
						}
						loop = true;
					}else {
						System.out.println("============== 登录失败 ============");
					}
					break;
				case "2":
					System.out.println("退出");
					loop = false;
					break;
				default:
					System.out.println("输入有误，请重新输入");
					break;
			}
		}
		System.out.println("退出了餐饮管理系统");
	}
	
	//完成结账
	public void payBill() {
		System.out.println("============== 结账 ============");
		System.out.println("请选择要结账的餐桌编号（-1 退出）");
		int diningTableId = In.nextInt();
		if(diningTableId==-1) {
			System.out.println("============== 取消结账 ============");
			return;
		}
		//验证餐桌是否存在
		DiningTable diningTable = dtService.getDiningTableById(diningTableId);
		if(diningTable==null) {
			System.out.println("============== 结账的餐桌不存在 ============");
			return;
		}
		//验证餐桌是否有需要结账的账单 
		if(!bService.hasPayBillByDiningTableId(diningTableId)) {
			System.out.println("============== 该餐位没有未结账账单 ============");
			return;
		}
		String payMode;
		while(true) {
			System.out.println("结账方式：现金/支付宝/微信 (回车取消结账)");
			payMode = In.next();
			if(payMode.equals("")) {
				System.out.println("============== 取消结账 ============");
				return;
			}else if(payMode.equals("现金")||payMode.equals("支付宝")||payMode.equals("微信"))
				break;
			else {
				System.out.println("想吃霸王餐？没门");
			}
		}
		while(true) {
			System.out.println("确认是否结账（Y/N）");
			String yn = In.next();
			if(yn.equalsIgnoreCase("Y")) {
				break;
			}else if(yn.equalsIgnoreCase("N")){
				System.out.println("============== 取消结账 ============");
				return;
			}else {
				System.out.println("输入错误了，重新输入");
			}
		}
		// 
		if(bService.payBill(diningTableId, payMode)){
			System.out.println("============== 结账成功 ============");
		}else {
			System.out.println("============== 结账失败 ============");
		}
		
		
	}
	
	//显示账单信息
	public void listBill() {
		List<Bill> list = bService.list();
		System.out.println("\n编号\t菜品号\t菜品量\t金额\t桌号\t日期\t\t\t状态");
		for (Bill bill : list) {
			System.out.println(bill);
		}
	}
	
	//点餐的方法
	public void orderMenu() {
		System.out.println("============== 点餐 ============");
		System.out.println("请输入点餐的桌号（-1 退出）");
		int orderDiningTableId = In.nextInt();
		if(orderDiningTableId==-1) {
			System.out.println("============== 取消点餐 ============");
			return;
		}
		System.out.println("请输入点餐的菜品号（-1 退出）");
		int orderMenuId = In.nextInt();
		if(orderMenuId==-1) {
			System.out.println("============== 取消点餐 ============");
			return;
		}
		System.out.println("请输入点餐的菜品数量（-1 退出）");
		int orderNums = In.nextInt();
		if(orderNums==-1) {
			System.out.println("============== 取消点餐 ============");
			return;
		}
		//验证餐桌号是否存在
		DiningTable diningTable = dtService.getDiningTableById(orderDiningTableId);
		if(diningTable==null) {
			System.out.println("============== 餐桌号不存在 ============");
			return;
		}
		// 验证菜品编号
		Menu menu = mService.getMenuById(orderMenuId);
		if(menu==null) {
			System.out.println("============== 菜品号不存在 ============");
			return;
		}
		// 点餐
		if(bService.orderMenu(orderMenuId, orderNums, orderDiningTableId)) {
			System.out.println("============== 点餐成功 ============");
		}else {
			System.out.println("============== 点餐失败 ============");
		}
		
	}
	
	
	//显示所有菜品
	public void listMenu() {
		List<Menu> list = mService.list();
		System.out.println("\n菜品编号\t菜品名\t类别\t价格");
		for (Menu menu : list) {
			System.out.println(menu);
		}
	}
	
	//完成定桌
	public void orderDiningTable() {
		System.out.println("============== 预定餐桌 ============");
		System.out.println("请选择要预定的餐桌编号（-1 退出）");
		int orderId = In.nextInt();
		if(orderId == -1) {
			System.out.println("============== 取消预定 ============");
			return;
		}
		while(true) {
			System.out.println("确认是否预定（Y/N）");
			String yn = In.next();
			if(yn.equalsIgnoreCase("Y")) {
				break;
			}else if(yn.equalsIgnoreCase("N")){
				System.out.println("============== 取消预定 ============");
				return;
			}else {
				System.out.println("输入错误了，重新输入");
			}
		}
		// 判断该餐桌的状态是否为null
		DiningTable diningTable = dtService.getDiningTableById(orderId);
		if(diningTable==null) {
			System.out.println("============== 预定餐桌不存在 ============");
			return;
		}
		if(!(diningTable.getState().equals("空"))) {
			System.out.println("============== 该餐桌已被预定或就餐中 ============");
			return;
		}
		System.out.println("预定人的名字：");
		String orderName = In.next();
		System.out.println("预定人的电话号码：");
		String orderTel = In.next();
		if(dtService.orderDiningTable(orderId, orderName, orderTel)) {
			System.out.println("============== 预定成功 ============");
		}else {
			System.out.println("============== 预定失败 ============");
		}
		
	}
	
	//显示餐桌状态
	public void listDiningTable() {
		System.out.println("桌号\t\t状态");
		List<DiningTable> list = dtService.list();
		for (DiningTable d : list) {
			System.out.println(d);
		}
	}
}
