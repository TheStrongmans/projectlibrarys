package com.qq.server;

import java.io.IOException;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import com.qq.entity.Message;
import com.qq.entity.MessageType;
import com.qq.entity.User;

/**
 * 完成用户登录验证
 * @author stephen
 *	
 */
public class UserClientService {
	private User u = new User();
	Socket socket;
	 
	public boolean checkUser(String userId,String pwd) {
		boolean l = false;
		u.setUserId(userId);
		u.setPasswd(pwd);
		//连接到服务端，发送u对象
		try {
			socket = new Socket(InetAddress.getLocalHost(),9999);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(u);//发送User对象
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			Message ms = (Message)ois.readObject();
			if(ms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) {
				//创建一个和服务器端保持通讯的线程->创建一个类ClientConnectServerThread
				ClientConnectServerThread ccst = new ClientConnectServerThread(socket);
				ccst.start();
				//为客户端扩展，将线程放入集合中
				ManageClientConnectServerThread.add(userId, ccst); 
				
				l = true;
			}else {
				socket.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
	//向服务端请求在线用户列表
	public void onlineFrilendList() {
		//发送一个Message 类型MESSAGE_GET_ONLINE_FRIENO
		Message  message = new Message();
		message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIENO);
		message.setSender(u.getUserId());
		//发送给服务器
		//应得到当前线程的Socket 对应的ObjectOutputStream 对象
		try {
			ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.get(u.getUserId()).getSocket().getOutputStream());
			
			oos.writeObject(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 退出客户端，并给服务端发送一个退出系统的message对象
	public void logout() {
		Message message = new Message();
		message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
		message.setSender(u.getUserId()); 
		try {
			ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.get(u.getUserId()).getSocket().getOutputStream());
			oos.writeObject(message);
			ManageClientConnectServerThread.remove(u.getUserId());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
