package com.chat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Sent implements Runnable{
	private Socket client;
	private DataOutputStream dos;
	private BufferedReader console;
	private DataInputStream result;
	private String sname;
	private String message;
	private String datas2 ;
	boolean isTrue = true;
	private boolean isRunning = true;
	public Sent(Socket client) throws IOException {
		this.client = client;
		dos = new DataOutputStream(client.getOutputStream());
		console = new BufferedReader(new InputStreamReader(System.in));
		result = new DataInputStream(client.getInputStream());
	}
	public void run() {
		while(isRunning) {
		try {
			sent();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("sent");
			isRunning = false;
				
		}
	
	}
	}
	public void sent() throws IOException {
		while(isTrue) {
		//System.out.println("请输入发送消息的对象");
		sname = console.readLine();
		//System.out.println("请输入消息内容");
		message = console.readLine();
		dos.writeUTF(sname+"&"+message);
		dos.flush();
		datas2 = result.readUTF();
		System.out.println(datas2);
		//System.out.println("是否注销用户yes/no");
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
	}
}