package com.catering.service;

import com.catering.dao.EmployeeDao;
import com.catering.entity.Employee;

/**
 * 完成对employee 表的各种操作（通过调用EmployeeDao对象完成）
 * @author stephen
 *
 */
public class EmployessService {
	private EmployeeDao employeeDao = new EmployeeDao();
	
	// 方法，根据empid 和pwd 返回一个Employee对象
	// 如果查询不到返回null
	public Employee getEmployeeByIdAndPwd(String empId,String pwd) {
		return employeeDao.queryStringle("select * from employee where empId=? and pwd=md5(?)", Employee.class, empId,pwd);
	}
}
