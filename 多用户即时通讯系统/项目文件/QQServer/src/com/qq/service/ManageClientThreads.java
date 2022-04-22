package com.qq.service;
/**
 * 管理和客户端的线程
 * @author stephen
 *
 */

import java.util.HashMap;
import java.util.Iterator;

public class ManageClientThreads {
	private static HashMap<String, ServerConnectClientThread> map = new HashMap<String, ServerConnectClientThread>();
	
	public static void add(String userId,ServerConnectClientThread scct) {
		map.put(userId, scct);
	}
	public static ServerConnectClientThread get(String userId) {
		return map.get(userId);
	}
	
	//返回在线用户列表
	public static String getOnLineUser() {
		//
		Iterator<String> iterator = map.keySet().iterator();
		String onlineUserList = "";
		while(iterator.hasNext()) {
			onlineUserList += iterator.next()+" ";
		}
		return onlineUserList;
	}
	
	//从集合中移除某个线程对象
	public static void remove(String userId) {
		map.remove(userId);
	}
	
	public static HashMap<String, ServerConnectClientThread> getMap() {
		return map;
	}
	
	public static boolean contains(String userId) {
//		System.out.println(map.containsKey(userId));
		return map.containsKey(userId);
	}
}
