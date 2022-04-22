package com.qq.entity;

import java.io.Serializable;

/**
 * 一个用户信息
 * @author stephen
 *
 */
public class User implements Serializable{
	private String userId;//ID
	private String passwd;//密码
	private static final long serialVersionUID = 1L;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String userId, String passwd) {
		super();
		this.userId = userId;
		this.passwd = passwd;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
}
