package com.qq.view;

import com.qq.server.FileClientService;
import com.qq.server.MessageClientServer;
import com.qq.server.UserClientService;
import com.qq.utils.In;

public class QQView {
	private boolean loop = true;//是否显示菜单
	public static String key = "";
	private UserClientService ucs = new UserClientService();//用于登录/注册
	private MessageClientServer mcs = new MessageClientServer();//消息
	private FileClientService fcs = new FileClientService();//文件
	
	public static void main(String[] args) {
	new QQView().mainMenu();
	}
	//显示主菜单
	private void mainMenu() {
		while(loop) {
			System.out.println("==============欢迎登录网络通讯系统==============");
			System.out.println("\t\t 1 登录系统");
			System.out.println("\t\t 9 退出系统");
			System.out.println("请选择：");
			key = In.next();
			switch (key) {
			case "1":
//				System.out.println("登录系统");
				System.out.println( "请输入用户名/ID:");
				String userId = In.next();
				System.out.println("请输入密码：");
				String psd = In.next();
				//需要到服务端验证是否合法
				//...
				if(ucs.checkUser(userId, psd)) {
					System.out.println("登录成功！！！");
					//进入二级菜单
					while(loop) {
						System.out.println("=============== 网络通讯 (用户 "+userId+") ===============");
						System.out.println("\t\t 1 显示在线用户列表");
						System.out.println("\t\t 2 群发消息");
						System.out.println("\t\t 3 私聊");
						System.out.println("\t\t 4 发送文件");
						System.out.println("\t\t 9 退出登录");
						System.out.println("请选择：");
						key = In.next();
						switch (key) {
						case "1":
//							System.out.println("显示在线用户列表");
							ucs.onlineFrilendList();
							break;
						case "2":
//							System.out.println("群发");
							System.out.println("请输入想和大家说的话：");
							String s = In.next();
							//
							mcs.sedMessageToAll(s, userId);
							break;
						case "3":
//							System.out.println("私聊");
							System.out.println("请输入想聊天的用户号（在线）：");
							String geterId = In.next();
							System.out.println("请输入想说的话");
							String content = In.next();
							//将消息发送到服务端
							mcs.sendMessageToOne(content, userId, geterId);
							break;
						case "4":
//							System.out.println("发送文件");
							System.out.println("请输入发送给（在线）用户：");
							String getterId = In.next();
							System.out.println("请输入发送文件的路径(形式 d:\\xx.jpg)");
							String src = In.next();
							System.out.println("请输入文件发送到对方的路径(形式 d:\\xx.jpg)");
							String dest = In.next();
							fcs.sendFileToOne(src, dest, userId, getterId);
							break;
						case "9":
							System.out.println("已退出登录");
							//调用方法，给服务器发送一个退出系统的message
							ucs.logout();
							loop = false;
							break;
						default:
							System.out.println("输入错误");
							break;
						}
					}
					loop = true;
				}else {
					System.out.println("用户名/ID或密码有误");
				}
				break;
			case "9":
				System.out.println("已退出系统");
				loop = false;
				break;
			default:
				System.out.println("输入错误");
				break;
			}
			
		}
	}
}
