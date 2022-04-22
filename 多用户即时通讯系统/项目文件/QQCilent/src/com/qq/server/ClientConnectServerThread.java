package com.qq.server;

import java.io.*; 
import java.net.Socket;

import com.qq.entity.Message;
import com.qq.entity.MessageType;
import com.qq.view.QQView;

public class ClientConnectServerThread extends Thread {
	private Socket socket;//线程持有Socket
	
	public ClientConnectServerThread(Socket socket) {
		super();
		this.socket = socket;
	}
	
	public Socket getSocket() {
		return socket;
	}
	
	@Override
	public void run() {
		//Thread需要在后台和服务器通讯,while
		while(true) {
			System.out.println("客户端线程，等待从读取从服务器端发送的消息");
			
			try {
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				//如果服务器没有发送Message对象，线程阻塞在这
				Message message = (Message)ois.readObject();
				//...
				//判断这个message类型，然后做相应的业务处理
				if(message.getMesType().equals(MessageType.MESSAGE_RET_ONLINE_FRIENO)) {
					//读取到的是 服务端返回的在线用户列表
					//取出在线列表信息，并显示
					// 规定
					String[] onlineUsers = message.getContent().split(" ");
					System.out.println("======== 当前在线用户列表 =======");
					for(int i = 0;i < onlineUsers.length;i++) {
						System.out.println("用户："+onlineUsers[i]);
					}
				}else if(message.getMesType().equals(MessageType.MESSAGE_COMM_MES)){
					//聊天消息
					System.out.println("\n"+message.getSender()+" 对 "+message.getGetter()+" 说 "+message.getContent());
				}else if(message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)) {
					System.out.println("\n"+message.getSender()+" 对 所有人 说 "+message.getContent());
				}else if(message.getMesType().equals(MessageType.MESSAGE_FILE_MES)) {
					//文件消息
					System.out.println("\n"+message.getSender()+" 给 "+message.getGetter()+" 发送文件 "+message.getSrc()+" 到我的电脑目录 "+message.getDest());
					
					//取出message，将文件写入磁盘
					FileOutputStream fos = new FileOutputStream(message.getDest());
					fos.write(message.getFileBytes());
					fos.close();
					System.out.println("\n 文件保存成功...");
				}
			}  catch (Exception e) {
				if(QQView.key.equals("9")) {
					break;
				}else {
					System.out.println("\n 与服务端失去连接 !!!");
					System.exit(0);
				}
				
			}
		}
	}
	
	
}
