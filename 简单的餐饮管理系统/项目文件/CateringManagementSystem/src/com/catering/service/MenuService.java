package com.catering.service;

import java.util.List;

import com.catering.dao.MenuDao;
import com.catering.entity.Menu;

public class MenuService {
	MenuDao mDao = new MenuDao();
	// 返回所有的菜单，并返回给界面
	public List<Menu> list(){
		return mDao.queryMulti("select * from menu", Menu.class,null);
	}
	
	// 根据id返回Menu对象
	public Menu getMenuById(int id) {
		return mDao.queryStringle("select * from menu where id=?", Menu.class, id);
	}
}
