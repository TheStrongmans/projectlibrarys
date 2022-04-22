package com.qq.server;

import java.io.*;

import com.qq.entity.Message;
import com.qq.entity.MessageType;

/**
 * 文件传输服务
 * @author stephen
 *
 */
public class FileClientService {
	/**
	 * 
	 * @param src 源文件路径
	 * @param dest 文件传输到对方的路径
	 * @param senderId 发送用户id
	 * @param getterId 接收用户id
	 */
	public void sendFileToOne(String src,String dest,String senderId,String getterId) {
		//读取src文件
		Message message = new Message();
		message.setMesType(MessageType.MESSAGE_FILE_MES);
		message.setSender(senderId);
		message.setGetter(getterId);
		message.setSrc(src);
		message.setDest(dest);
		
		//文件读取
		FileInputStream fis = null;
		byte[] fileBytes = new byte[(int)new File(src).length()];
		try {
			fis = new FileInputStream(src);
			fis.read(fileBytes);//将src文件读取到字节数组
			message.setFileBytes(fileBytes); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fis !=null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		System.out.println("\n" + senderId +  " 给 "+getterId +" 发送文件："+src+" 到对方电脑目录 "+dest);
		try {
			ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.get(senderId).getSocket().getOutputStream());
			oos.writeObject(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}	
