package com.qq.server;
/**
 * 管理客户端连接到服务端的线程类
 * @author stephen
 *
 */

import java.util.HashMap;

public class ManageClientConnectServerThread {
	private static HashMap<String, ClientConnectServerThread> map = new HashMap<String, ClientConnectServerThread>();
	
	//将一个线程添加到集合
	public static void add(String userId,ClientConnectServerThread ccst) {
		map.put(userId, ccst);
	}
	//通过id获取对应线程
	public static ClientConnectServerThread get(String userId) {
		return map.get(userId); 
	}
	
	//通过id移除对应线程
	public static void remove(String userId) {
		map.remove(userId);
	}
}
