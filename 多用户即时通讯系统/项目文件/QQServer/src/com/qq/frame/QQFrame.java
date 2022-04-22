package com.qq.frame;

import com.qq.service.QQServer;
import com.qq.service.SendNewsToAllService;
import com.qq.utils.In;

public class QQFrame {
	public static void main(String[] args) {
		new Thread(new SendNewsToAllService()).start();
		new QQServer();
		
		
		
	}
}
