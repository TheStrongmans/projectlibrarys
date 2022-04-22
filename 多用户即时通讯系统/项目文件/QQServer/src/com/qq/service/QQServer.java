package com.qq.service;
/**
 * 服务端，监听9999端口，等待客户端的连接
 * @author stephen
 *
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qq.entity.Message;
import com.qq.entity.MessageType;
import com.qq.entity.User;

public class QQServer {
	private ServerSocket ss = null;
	private User u;
	public static HashMap<String, String> validUsers = new HashMap<String, String>();
	static {
		validUsers.put("100","123456");
		validUsers.put("200","123456");
		validUsers.put("300","123456");
		validUsers.put("400","123456");
		validUsers.put("500","123456");
		validUsers.put("600","123456");
	}
	
	public QQServer(){
		System.out.println("服务端在9999端口监听...");
		try {
			ss = new ServerSocket(9999);
			while(true) {//当和某个客户端连接后，继续监听
				Socket socket = ss.accept();//如果没有客户端连接就会阻塞
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				u = (User)ois.readObject(); 
				Message message = new Message();
				//验证用户
				if(validUsers.containsKey(u.getUserId()) && u.getPasswd().equals(validUsers.get(u.getUserId()))) {
//					
					//验证成功
					message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
					oos.writeObject(message);
					
					//创建一个线程，和客户端保持通讯，该线程需要持有socket对象
					ServerConnectClientThread scct = new ServerConnectClientThread(socket, u.getUserId());
					//启动线程
					scct.start();
					//把该线程对象，放入到一个集合中，进行管理
					ManageClientThreads.add(u.getUserId(), scct);
					one();
				}else {
					//验证失败 
					message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
					oos.writeObject(message);
					socket.close();
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//如果服务器退出了一个while 说明服务器不在监听，因此关闭ServerSocket
			try {
				ss.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void one() {
		try {
			Thread.sleep(50);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//客户端登录成功，若此客户有离线消息将离线信息发送给此客户端
		ObjectOutputStream oos;
		if(OfflineMessages.containsKey(u.getUserId())) {
			List<Message> messages = OfflineMessages.get(u.getUserId());
			for (Message message2 : messages) {
				try {
					oos = new ObjectOutputStream(ManageClientThreads.get(u.getUserId()).getSocket().getOutputStream());
					oos.writeObject(message2);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			OfflineMessages.remover(u.getUserId());
		}
	}
}
