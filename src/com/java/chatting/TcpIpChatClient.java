package com.java.chatting;

import java.io.IOException;
import java.net.*;

public class TcpIpChatClient {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("192.168.0.62",7777);
			System.out.println("������ ����Ǿ����ϴ�..");
			
			Sender sender = new Sender(socket);
			sender.start();
			
			Receiver receiver = new Receiver(socket);
			receiver.start();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
