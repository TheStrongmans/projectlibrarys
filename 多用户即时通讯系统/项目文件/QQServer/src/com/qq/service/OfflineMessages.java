package com.qq.service;
/**
 * 离线消息
 * @author stephen
 *
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.qq.entity.Message;

public class OfflineMessages {
	private static HashMap<String,List<Message>> map = new HashMap<>();
	
	public static void add(String userId,Message massage) {
		if(map.containsKey(userId)) {
			get(userId).add(massage);
		}else {
			List<Message> list = new ArrayList<Message>();
			list.add(massage);
			map.put(userId, list);
		}
	}
	public static List<Message> get(String userId){
		return map.get(userId);
	}
	public static void remover(String userId) {
		map.remove(userId);
	}
	public static boolean containsKey(String userId) {
		System.out.println(map.containsKey(userId));
		return map.containsKey(userId);
	}
}
