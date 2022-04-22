package com.qq.service;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import com.qq.entity.Message;
import com.qq.entity.MessageType;
import com.qq.utils.In;

/**
 * 
 * @author stephen
 *
 */
public class SendNewsToAllService implements Runnable{

	@Override
	public void run() {
		while(true) {
			System.out.println("可选择");
			System.out.println("1 推送消息");
			System.out.println("2 关闭服务端");
			String s = In.next();
			if(s.equals("1")) {
				one();
			}else if(s.equals("2")) {
				System.out.println("确定要关闭服务端吗(yes/no)");
				String yesOrNo = In.next().toUpperCase();
				if(yesOrNo.equals("YES")) {
					System.out.println("\n 已关闭服务端");
					System.exit(0);
				}
			}else {
				System.out.println("输入错误");
			}
			
		}
//		while(true) {
			
//		}
	}
	
	private void one() {
		System.out.println("请输入服务器要推送的消息");
		String s = In.next();
		//
		Message message = new Message();
		message.setMesType(MessageType.MESSAGE_TO_ALL_MES);
		message.setSender("服务器");
		message.setContent(s);
		message.setSendTime(new Date().toString());
		System.out.println("服务器推送消息给所有人 "+s);
		
		//遍历所有的通讯线程，的得到socket
//		HashMap<String, ServerConnectClientThread> map = ManageClientThreads.getMap();
//		Iterator<String> iterator = map.keySet().iterator();
//		while(iterator.hasNext()) {
//			String onLineUserId = iterator.next();
//			try {
////				ObjectOutputStream oos = new ObjectOutputStream(map.get(onLineUserId).getSocket().getOutputStream());
////				oos.writeObject(message);
//				ServerConnectClientThread.write(message);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		Iterator<String> iterator = QQServer.validUsers.keySet().iterator();
		while(iterator.hasNext()){
			String onLineUserId = iterator.next();
			if(!onLineUserId.equals(message.getSender())) {
//				 ObjectOutputStream oos = new ObjectOutputStream(map.get(onLineUserId).getSocket().getOutputStream());
//				   oos.writeObject(message);
				message.setGetter(onLineUserId);
				ServerConnectClientThread.write(message);
			}
		}
	}

}
