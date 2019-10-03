package com.chat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
/*此客户端与服务端只能完成一次交流
 * 客户端的多线程有待完善
 * 功能缺失严重。
 * 知识丰富后，必将完善。
 */
public class Client {
		
		public static void main(String[] args) throws UnknownHostException, IOException {
			System.out.println("--------Client-------");
			BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
			Socket client = new Socket("localhost",10007);
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			DataInputStream result = new	DataInputStream(client.getInputStream());
			boolean isTrue = true;
			System.out.print("请注册用户名(不能包含数字)");
			//用户注册；
			String rname = console.readLine();
			dos.writeUTF("rname="+rname);
			String datas = result.readUTF();
			System.out.println(datas);
			dos.flush();
			//用户名登陆：
			System.out.print("请输入用户名");
			String uname = console.readLine();
			dos.writeUTF("uname="+uname);
			String datas1 = result.readUTF();
			System.out.println(datas1);
			dos.flush();
			//消息发送给客户端；
			//若不注销用户则一直循环
			while(isTrue) {
			System.out.print("请输入发送消息的对象");
			String sname = "";
			String message = "";
			sname = console.readLine();
			System.out.print("请输入消息内容");
			message = console.readLine();
			dos.writeUTF(sname+"&"+message);
			dos.flush();
			//返回发送结果
			
			String datas2 = result.readUTF();
			System.out.println(datas2);
			if(datas2.contains("发送失败")) {
				continue;
			}
			String datas3 = result.readUTF();
			if(datas3!=null) {
				System.out.println(datas3);
			}
			//注销用户
			System.out.println("是否注销用户yes/no");
			String yn = console.readLine();
			dos.writeUTF(yn);
			if(yn.contains("no")) {
			continue;
			
			}else {
				String datas4 = result.readUTF();
				System.out.println(datas4);
				isTrue = false;
			}
			}
			result.close();
			dos.close();
			client.close();
			
		}
}
		