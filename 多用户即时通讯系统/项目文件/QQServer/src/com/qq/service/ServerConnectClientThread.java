package com.qq.service;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

import com.qq.entity.Message;
import com.qq.entity.MessageType;

/**
 * 该类对象和某个客户端保持通讯
 * @author stephen
 *
 */
public class ServerConnectClientThread extends Thread{
	private Socket socket;
	private String userId;//所连接客户端的id
	
	public Socket getSocket() {
		return socket;
	}

	public ServerConnectClientThread(Socket socket, String userId) {
		super();
		this.socket = socket;
		this.userId = userId;
	}


	@Override
	public void run() {//线程除以run状态，可以发送/接收消息
		while(true) {
			System.out.println("服务端和客户端 "+userId+" 保持通讯，读取数据...");
			try {
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				Message message = (Message)ois.readObject();
				//...
				//根据message的类型，做相应的业务处理
				if(message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIENO)) {
					System.out.println(message.getSender()+" 想获取在线用户列表");
					//客户端要在线用户列表
					String onlineUser = ManageClientThreads.getOnLineUser();
					//构建一个Massage对象，返回给客户端
					Message message2 = new Message();
					message2.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIENO);
					message2.setContent(onlineUser);
					message2.setGetter(message.getSender());
					//写入到数据通道，
					ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
					oos.writeObject(message2);
				}else if(message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)){
					System.out.println(message.getSender() +" 退出...");
					//将这个客户端再集合中移除
					ManageClientThreads.remove(message.getSender());
					socket.close();//关闭连接
					break;//退出线程
				}else if(message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {
					//私聊
					//获得发送对象的线程
					write(message);
				}else if(message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)) {
					//需要遍历 管理线程的集合，把所有的线程的socket得到，然后把message进行转发即可
					Iterator<String> iterator = QQServer.validUsers.keySet().iterator();
					while(iterator.hasNext()){
						String onLineUserId = iterator.next();
						if(!onLineUserId.equals(message.getSender())) {
//							 ObjectOutputStream oos = new ObjectOutputStream(map.get(onLineUserId).getSocket().getOutputStream());
//							   oos.writeObject(message);
							message.setGetter(onLineUserId);
							write(message);
						}
					}
					System.out.println(1);
				}else if(message.getMesType().equals(MessageType.MESSAGE_FILE_MES)) {
					//发文件
//					ObjectOutputStream oos = new ObjectOutputStream(ManageClientThreads.get(message.getGetter()).getSocket().getOutputStream());
//					//转发
//					oos.writeObject(message);
					write(message);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//判断客户端是否在线，在线直接发送消息，否则存入离线消息中
	public static void write(Message message) {
		if(ManageClientThreads.contains(message.getGetter())) {
			//获得发送对象线程的输出流
			ObjectOutputStream oos;
			try {
				oos = new ObjectOutputStream(ManageClientThreads.get(message.getGetter()).getSocket().getOutputStream());
				oos.writeObject(message); //转发，若果客户不在线，可以保存到数据库，这样可以实现离线留言 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			OfflineMessages.add(message.getGetter(), message);
		}
	}
}
