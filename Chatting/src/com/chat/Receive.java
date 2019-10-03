package com.chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receive implements Runnable{
	private Socket client;
	private DataInputStream result;
	private boolean isRunning = true;
	public Receive(Socket client) throws IOException {
		this.client = client;
		result = new DataInputStream(client.getInputStream());
	}
		public void run() {
			while(isRunning) {
				try {
					receive();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("receive");
					isRunning = false;
				}
				
				
			}
		}
		public void receive() throws IOException {
			String datas3 = result.readUTF();
			if(datas3!=null) {
				System.out.println(datas3);
			}
		}
}
