package com.qq.server;

import java.io.*;
import java.util.Date;

import com.qq.entity.Message;
import com.qq.entity.MessageType;

/**
 * 提供和消息相关的服务方法
 * @author stephen
 *
 */
public class MessageClientServer {
	
	public void sedMessageToAll(String content,String senderId) {
		//构建message
		Message message = new Message();
		message.setMesType(MessageType.MESSAGE_TO_ALL_MES);//群发
		message.setSender(senderId);
		message.setContent(content);
		message.setSendTime(new Date().toString());//发送时间设置到message对象
		System.out.println(senderId+" 对 所有人 说 "+content);
		//发送给服务端
		try {
			ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.get(senderId).getSocket().getOutputStream());
			oos.writeObject(message);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 私聊
	 * @param content 内容
	 * @param senderId 发送用户id
	 * @param getterId 接收用户id
	 */
	public  void sendMessageToOne(String content,String senderId,String getterId) {
		//构建message
		Message message = new Message();
		message.setMesType(MessageType.MESSAGE_COMM_MES);
		message.setSender(senderId);
		message.setGetter(getterId);
		message.setContent(content);
		message.setSendTime(new Date().toString());//发送时间设置到message对象
		System.out.println(senderId+" 对 "+getterId+" 说 "+content);
		//发送给服务端
		try {
			ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.get(senderId).getSocket().getOutputStream());
			oos.writeObject(message);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
