package com.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;





public class Server {
	//装入容器判断 发送消息的人
	private static CopyOnWriteArrayList<Channel>  all = new CopyOnWriteArrayList<Channel>();
	public static void main(String[] args) throws IOException {
		
		System.out.println("--------Server-------");
		ServerSocket server = new ServerSocket(10007);
		boolean istrue = true;
		//创建多线，进行多个客户端的连接。
		while(istrue) {
		Socket client = server.accept();
		System.out.println("一个客户端建立了连接");
		Channel channel = new Channel(client);
		all.add(channel);
		Thread thread = new Thread(channel);
		thread.start();
	
	}
		server.close();
	}
	
	static class Channel implements Runnable {
		private Socket client;
		private DataInputStream dis ;
		private DataOutputStream dos;
		String datas;
		String rname = "";
		String uname = "";
		String datas1;
		String sname = "";
		String message = "";
		String datas2;
		private boolean isTrue;
		public Channel(Socket client) throws IOException {
			this.client = client;
			isTrue= true;
			dis = new	DataInputStream(client.getInputStream());
			dos = new DataOutputStream(client.getOutputStream());
		}
		//用户名注册
		public void Register() throws IOException {
			
			datas = dis.readUTF();
			String[] register = datas.split("=");
			 rname = register[1];
			 if(rname.matches("\\D+?")) {//用正则表达式匹配非数字的内容，用户名有数字失败，无数字成功。
					try {
						dos.writeUTF("用户名注册成功");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					try {
						dos.writeUTF("用户名注册失败");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			try {
				dos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		//用户登录
		public void Login() {
			try {
				datas1 = dis.readUTF();
				//用=号将“uname“与uname分开。
				String[] login = datas1.split("=");
				  uname = login[1];
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//若该用户名注册过 则返回成功，若没有则返回失败。
			   if(uname.contains(rname)) {
				   try {
					dos.writeUTF("登陆成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   }else {
				   try {
					dos.writeUTF("登陆失败");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   }
			   try {
				dos.flush();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

		}
		//信息的发送
		public void sentmessage() throws IOException {
			  try {
					datas2 = dis.readUTF();
						//用split将sname与message分开。
					   String [] receive = datas2.split("&");
					   sname = receive[0];
					   message = receive[1];
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				   try {
					   for(Channel other:all) {
						   //若发送的sname以存在则返回成功，否则返回失败。
						   if(this.sname.equals(other.uname)) {
							   dos.writeUTF("发送成功");
							   dos.flush();
					 }else {
						 dos.writeUTF("发送失败,用户名不存在");
						 dos.flush();
					 }
					   }
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				  
		}
		//将消息发送给sname
		public void sentother() throws IOException {
			for(Channel other:all)
				//如果存在则返回信息。
			if(other.uname.equals(sname)) {
				other.dos.writeUTF(message);
				dos.flush();
			}
		}
		//注销用户
		public void logout() throws IOException {
			
			dos.writeUTF("注销成功");
			//将此用户移除all列表。
			all.remove(this);
			dos.flush();
		}
	
		public void run() {
			try {
				Register();
				Login();
				while(isTrue) {
				sentmessage();
				sentother();
				String message = dis.readUTF();
				if(message.contains("no")) {
					continue;
				}else {
					isTrue = false;
				}
				}
				logout();
				
			} catch (IOException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}					 
			  try {	
				  
				dis.close();
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			}
	}
}
		
	
		
